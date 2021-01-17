package gg.rsmod.plugins.content.npcs.pets

Pets.values.forEach { pet ->
    can_drop_item(pet.pet) {
        dropPet(pet, world, player)
        return@can_drop_item false
    }

    on_npc_option(npc = pet.morph, option = "pick-up") {
        pickup(player, pet.pet)
    }

    on_npc_option(npc = pet.morph, option = "talk-to") {
        player.queue {
            dialog(this, pet.dialog)
        }
    }

    on_logout {
        returnToOwner(player, pet)
    }

    // Add all pets to the bank for test purpose
    /*on_login {
        player.bank.add(pet.pet, 1)
    }*/
}

suspend fun dialog(it: QueueTask, message : String) {
    it.chatNpc(message, animation = 588)
}

fun dropPet(pet : Pets, world : World, player : Player) {
    if(player.inventory.contains(pet.pet)) {

        if(world.npcs.any { npc -> npc.owner == player }) {
            player.message("You already got a friend spawned!")
            return
        }

        if(player.inventory.remove(pet.pet).hasSucceeded()) {
            val follow_timer = TimerKey()
            var spawnedPet = Npc(player, pet.morph, player.tile.step(Direction.NORTH, 1), world)

            spawnedPet.timers[follow_timer] = 1
            player.world.spawn(spawnedPet)
            spawnedPet.facePawn(player)

            on_timer(follow_timer) {

                if(spawnedPet.tile.isWithinRadius(player.tile, 10)) {
                    spawnedPet.walkTo(player.tile)
                } else {
                    player.world.remove(spawnedPet)
                    spawnedPet.spawnTile
                    spawnedPet = Npc(player, pet.morph, player.tile.step(Direction.NORTH, 1), world)
                    player.world.spawn(spawnedPet)
                    spawnedPet.facePawn(player)
                }

                spawnedPet.timers[follow_timer] = 1
            }
        }
    }
}

fun pickup(player : Player, pet : Int) {
    val npc = player.getInteractingNpc()

    if(npc.owner == player) {
        player.world.remove(npc)
        player.inventory.add(pet, 1)
    }
}

fun returnToOwner(player : Player, pet : Pets) {
    if(player.world.npcs.any { npc -> npc.owner == player && npc.id == pet.morph }) {
        if(player.inventory.freeSlotCount >= 1) {
            player.inventory.add(pet.pet, 1)
        } else {
            player.bank.add(pet.pet, 1)
        }
    }

    return
}