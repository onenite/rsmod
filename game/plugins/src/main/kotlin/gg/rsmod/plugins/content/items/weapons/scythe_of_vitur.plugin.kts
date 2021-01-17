package gg.rsmod.plugins.content.items.weapons

val scythe_varp = 1024

on_item_option(Items.SCYTHE_OF_VITUR, option = "check") {
    player.message("Current charges: " + player.getVarp(scythe_varp).toString())
}

on_equipment_option(Items.SCYTHE_OF_VITUR, option = "check") {
    player.message("Current charges: " + player.getVarp(scythe_varp).toString())
}

on_item_option(Items.SCYTHE_OF_VITUR, option = "uncharge") {
    if(!player.inventory.hasSpace) {
        player.message("Your inventory is full!")
        return@on_item_option
    }

    val charges = (player.getVarp(scythe_varp) / 100)

    if(charges == 0) {
        player.message("You dont have any charges.")
        return@on_item_option
    }

    player.setVarp(scythe_varp, 0)

    player.inventory.add(Items.VIAL_OF_BLOOD_NOTED, charges)
    player.message("You've uncharged your scythe and got $charges vials of blood.")
}

on_obj_option(Objs.VYRE_WELL_32985, option = "fill") {
    val vialCount = player.inventory.getItemCount(Items.VIAL_OF_BLOOD_22446)
    val notedCount = player.inventory.getItemCount(Items.VIAL_OF_BLOOD_NOTED)

    if(vialCount == 0 && notedCount == 0) {
        player.message("You dont have any vial of blood!")
        return@on_obj_option
    }

    player.inventory.remove(Items.VIAL_OF_BLOOD_22446, vialCount)
    player.inventory.remove(Items.VIAL_OF_BLOOD_NOTED, notedCount)
    player.setVarp(scythe_varp, player.getVarp(scythe_varp) + (vialCount * 100) + (notedCount * 100))

    val total = (vialCount * 100) + (notedCount * 100)

    if(vialCount > 0 || notedCount > 0) {
        player.message("The well charged the scythe with $total charges")
    }
}