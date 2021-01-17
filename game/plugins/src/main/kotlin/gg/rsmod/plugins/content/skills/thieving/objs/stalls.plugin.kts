package gg.rsmod.plugins.content.skills.thieving.objs

Stall.values().forEach{ stall ->
    if (stall == Stall.SEED_STALL){
        on_obj_option(stall.stallID, "Steal from") {
            stall.steal(player)
        }
        return@forEach
    }
    on_obj_option(stall.stallID, "Steal-from") {
        stall.steal(player)
    }
}