package gg.rsmod.plugins.content.skills.thieving.objs

import gg.rsmod.game.model.entity.DynamicObject
import gg.rsmod.game.model.entity.Player
import gg.rsmod.plugins.api.Skills
import gg.rsmod.plugins.api.cfg.Items
import gg.rsmod.plugins.api.cfg.Objs
import gg.rsmod.plugins.api.ext.*
import gg.rsmod.plugins.content.skills.thieving.objs.StallRewards.bakers_stall_steals
import gg.rsmod.plugins.content.skills.thieving.objs.StallRewards.crossbow_stall_steals
import gg.rsmod.plugins.content.skills.thieving.objs.StallRewards.fish_stall_steals
import gg.rsmod.plugins.content.skills.thieving.objs.StallRewards.fruit_stall_steals
import gg.rsmod.plugins.content.skills.thieving.objs.StallRewards.fur_stall_steals
import gg.rsmod.plugins.content.skills.thieving.objs.StallRewards.gem_stall_steals
import gg.rsmod.plugins.content.skills.thieving.objs.StallRewards.ore_stall_steals
import gg.rsmod.plugins.content.skills.thieving.objs.StallRewards.seed_stall_steals
import gg.rsmod.plugins.content.skills.thieving.objs.StallRewards.silk_stall_steals
import gg.rsmod.plugins.content.skills.thieving.objs.StallRewards.silver_stall_steals
import gg.rsmod.plugins.content.skills.thieving.objs.StallRewards.spice_stall_steals
import gg.rsmod.plugins.content.skills.thieving.objs.StallRewards.tea_stall_steals
import gg.rsmod.plugins.content.skills.thieving.objs.StallRewards.vegetable_stall_steals
import gg.rsmod.plugins.content.skills.thieving.objs.StallRewards.wine_stall_steals
import kotlin.random.Random

enum class Stall(val stallID: Int,  val minStealLevel: Int, val xpGain: Double, val respawnCycles: Int, val emptyStallId: Int = Objs.MARKET_STALL, val attemptMsg: String = "", val steals: Map<Int, String>) {
    VEGETABLE_STALL(Objs.VEG_STALL, 2, 10.0, 3, steals = vegetable_stall_steals),
    BAKERS_STALL(Objs.BAKERS_STALL, 5, 16.0, 4, steals = bakers_stall_steals),
    BAKERS_STALL2(Objs.BAKERS_STALL_11730, 5, 16.0, 4, steals = bakers_stall_steals),
    TEA_STALL(Objs.TEA_STALL, 5, 16.0, 8, emptyStallId = Objs.MARKET_STALL, attemptMsg = "a Cup of tea", steals = tea_stall_steals),
    TEA_STALL2(Objs.TEA_STALL_6574, 5, 16.0, 8, emptyStallId = Objs.MARKET_STALL, attemptMsg = "a Cup of tea", steals = tea_stall_steals),
    SILK_STALL(Objs.SILK_STALL_11729, 20, 24.0, 6, attemptMsg = "some silk", steals = silk_stall_steals),
    SILK_STALL2(Objs.SILK_STALL_36569, 20, 24.0, 6, attemptMsg = "some silk", steals = silk_stall_steals),
    WINE_STALL(Objs.MARKET_STALL_14011, 22, 27.0, 16, attemptMsg = "some wine", steals = wine_stall_steals),
    FRUIT_STALL(Objs.FRUIT_STALL_28823, 25, 28.5, 3, emptyStallId = Objs.FRUIT_STALL, attemptMsg = "some fruit", steals = fruit_stall_steals),
    SEED_STALL(Objs.SEED_STALL_7053, 27, 10.0, 16, emptyStallId = Objs.MARKET_STALL, attemptMsg = "some seeds", steals = seed_stall_steals),
    FUR_STALL(Objs.FUR_STALL_11732, 35, 42.0, 16, emptyStallId = Objs.MARKET_STALL, attemptMsg = "some fur", steals = fur_stall_steals),
    FISH_STALL(Objs.FISH_STALL, 42, 42.0, 16, emptyStallId = Objs.MARKET_STALL, steals = fish_stall_steals),
    FISH_STALL2(Objs.FISH_STALL_4705, 42, 42.0, 16, emptyStallId = Objs.MARKET_STALL, steals = fish_stall_steals),
    FISH_STALL3(Objs.FISH_STALL_4707, 42, 42.0, 16, emptyStallId = Objs.MARKET_STALL, steals = fish_stall_steals),
    FISH_STALL4(Objs.FISH_STALL_31712, 42, 42.0, 16, emptyStallId = Objs.MARKET_STALL, steals = fish_stall_steals),
    CROSSBOW_STALL(Objs.CROSSBOW_STALL, 49, 52.0, 15, emptyStallId = Objs.MARKET_STALL_6984, steals = crossbow_stall_steals),
    SILVER_STALL(Objs.SILVER_STALL_6164, 50, 54.0, 25, emptyStallId = Objs.MARKET_STALL_6984, attemptMsg = "some ore", steals = silver_stall_steals),
    SILVER_STALL2(Objs.SILVER_STALL_11734, 50, 54.0, 25, emptyStallId = Objs.MARKET_STALL, attemptMsg = "some ore", steals = silver_stall_steals),
    SILVER_STALL3(Objs.SILVER_STALL_36570, 50, 54.0, 25, emptyStallId = Objs.MARKET_STALL_36568, attemptMsg = "some ore", steals = silver_stall_steals),
//SEARCH OPTION*  SPICE_STALL(Objs.SPICE_STALL_6572, 65, 81.0, 64, emptyStallId = Objs.MARKET_STALL, attemptMsg = "some spice", steals = spice_stall_steals),
    SPICE_STALL2(Objs.SPICE_STALL_11733, 65, 81.0, 64, emptyStallId = Objs.MARKET_STALL, attemptMsg = "some spice", steals = spice_stall_steals),
//SEARCH OPTION*  SPICE_STALL3(Objs.SPICE_STALL_20348, 65, 81.0, 64, emptyStallId = Objs.MARKET_STALL_20349, attemptMsg = "some spice", steals = spice_stall_steals),
    SPICE_STALL4(Objs.SPICE_STALL_36572, 65, 81.0, 64, emptyStallId = Objs.MARKET_STALL_36568, attemptMsg = "some spice", steals = spice_stall_steals),
    GEM_STALL(Objs.GEM_STALL_6162, 75, 160.0, 160, emptyStallId = Objs.MARKET_STALL_6984, steals = gem_stall_steals),
    GEM_STALL2(Objs.GEM_STALL_11731, 75, 160.0, 160, emptyStallId = Objs.MARKET_STALL, steals = gem_stall_steals),
    GEM_STALL3(Objs.GEM_STALL_36571, 75, 160.0, 160, emptyStallId = Objs.MARKET_STALL_36568, steals = gem_stall_steals),
    GEM_STALL4(Objs.SHOP_COUNTER_30280, 75, 160.0, 160, emptyStallId = Objs.SHOP_COUNTER_30278, steals = gem_stall_steals),
    ORE_STALL(Objs.SHOP_COUNTER_30279, 82, 180.0, 96, emptyStallId = Objs.SHOP_COUNTER_30278, steals = ore_stall_steals)
;
    fun steal(player: Player) {
        if(!player.inventory.hasSpace){
            player.queue {
                messageBox("Your inventory is too full to hold any more.")
            }
            return
        }

        if (player.getSkills()[Skills.THIEVING].currentLevel < minStealLevel) {
            player.queue {
                messageBox("You need to be level $minStealLevel to steal from the ${stallID.getObjName(player.world.definitions, lowercase = true)}.")
            }
            return
        }

        if (attemptMsg != "") {
            val defaultMsg = when {
                this == WINE_STALL -> "You attempt to steal #STEAL from the #STALL.".replace("#STEAL", attemptMsg).replace("#STALL", "wine merchant's stall")
                this == SEED_STALL -> "You attempt to steal #STEAL from the #STALL.".replace("#STEAL", attemptMsg).replace("#STALL", "seed merchant's stall")
                else -> "You attempt to steal #STEAL from the #STALL.".replace("#STEAL", attemptMsg).replace("#STALL", stallID.getObjName(player.world.definitions, lowercase = true))
            }
            player.message(defaultMsg)
        }

        val selector = Random.nextInt(0, steals.size)
        val item = steals.keys.toList()[selector]

        if (player.inventory.add(item).hasSucceeded()) {
            player.queue {
                player.lock()
                wait(1)
                player.animate(832)
                player.playSound(2581)

                val outMsg = "You steal #STEAL.".replace("#STEAL", steals[item] ?: "everything!")
                player.addXp(Skills.THIEVING, xpGain)

                player.world.queue {
                    val obj = player.getInteractingGameObj()
                    player.world.remove(obj)
                    player.message(outMsg)

                    val other = DynamicObject(obj, emptyStallId)
                    player.world.spawn(other)
                    wait(respawnCycles)
                    player.world.remove(other)
                    player.world.spawn(DynamicObject(obj))
                }
                player.unlock()
            }
        }
    }
}
//Mapping of all the stalls*
 object StallRewards{
    val vegetable_stall_steals = mapOf(
        Items.ONION to "an onion",
        Items.CABBAGE to "a cabbage",
        Items.POTATO to "a potato",
        Items.TOMATO to "a tomato",
        Items.GARLIC to "a clove of garlic")

    val bakers_stall_steals = mapOf(
        Items.CAKE to "a cake",
        Items.CHOCOLATE_SLICE to "a chocolate slice",
        Items.BREAD to "some bread")

     val silk_stall_steals = mapOf(Items.SILK to "some silk")

     val tea_stall_steals = mapOf(Items.CUP_OF_TEA to "a Cup of tea")

     val fur_stall_steals = mapOf(
         Items.FUR to "some fur",
         Items.GREY_WOLF_FUR to "some grey wolf fur")

     val wine_stall_steals = mapOf(
         Items.JUG_OF_WATER to "a Jug of water",
         Items.JUG_OF_WINE to "a Jug of wine",
         Items.GRAPES to "some grapes",
         Items.JUG to "an empty Jug",
         Items.BOTTLE_OF_WINE to "a bottle of wine")

     val seed_stall_steals = mapOf(
         Items.POTATO_SEED to "some potato seeds",
         Items.ONION_SEED to "some onion seeds",
         Items.CABBAGE_SEED to "some cabbage seeds",
         Items.TOMATO_SEED to "some tomato seeds",
         Items.SWEETCORN_SEED to "some sweetcorn seeds",
         Items.STRAWBERRY_SEED to "some strawberry seeds",
         Items.WATERMELON_SEED to "some watermelon seeds",
         Items.SNAPE_GRASS_SEED to "some snape grass seeds")

     val fish_stall_steals = mapOf(
         Items.RAW_SALMON to "a salmon",
         Items.RAW_TUNA to "a tuna",
         Items.RAW_LOBSTER to "a lobster")

    val crossbow_stall_steals = mapOf(
        Items.BRONZE_BOLTS to "some bronze bolts",
        Items.BRONZE_LIMBS to "some bronze limbs",
        Items.WOODEN_STOCK to "a wooden stock")

    val silver_stall_steals = mapOf(
        Items.SILVER_ORE to "some silver ore")

    val spice_stall_steals = mapOf(
        Items.SPICE to "some spice")

    val gem_stall_steals = mapOf(
        Items.UNCUT_SAPPHIRE to "an uncut sapphire",
        Items.UNCUT_EMERALD to "an uncut emerald",
        Items.UNCUT_RUBY to "an uncut ruby",
        Items.UNCUT_DIAMOND to "an uncut diamond",
        Items.UNCUT_DRAGONSTONE to "an uncut dragonstone",
        Items.UNCUT_ONYX to "an uncut onyx")

    val ore_stall_steals = mapOf(
        Items.IRON_ORE to "an iron ore",
        Items.SILVER_ORE to "a silver ore",
        Items.COAL to "a coal",
        Items.GOLD_ORE to "a gold ore",
        Items.MITHRIL_ORE to "a mithril ore",
        Items.ADAMANTITE_ORE to "an adamantite ore",
        Items.RUNITE_ORE to "a runite ore")

     val fruit_stall_steals = mapOf(
         Items.COOKING_APPLE to "an apple",
         Items.BANANA to "a banana",
         Items.STRAWBERRY to "a strawberry",
         Items.REDBERRIES to "some redberries",
         Items.JANGERBERRIES to "some jangerberries",
         Items.STRANGE_FRUIT to "a strange fruit",
         Items.LIME to "a lime",
         Items.LEMON to "a lemon",
         Items.PINEAPPLE to "a pineapple",
         Items.PAPAYA_FRUIT to "a papaya fruit",
         Items.GOLOVANOVA_FRUIT_TOP to "a golovanova fruit top")
}