package gg.rsmod.plugins.content.npcs.pets

import gg.rsmod.plugins.api.cfg.Items
import gg.rsmod.plugins.api.cfg.Npcs

enum class Pets(val pet: Int, val dialog: String, val morph: Int, val petName: String) {
    // Boss pets
    LIL_ZIK(pet = Items.LIL_ZIK, dialog = "Hi mortal", morph = Npcs.LIL_ZIK_8336, petName = "Lil'Zik"),
    OLMLET(pet = Items.OLMLET, dialog = "Testmessage", morph = Npcs.OLMLET_7519, petName = "Olmlet"),
    SMOLCANO(pet = Items.SRARACHA, dialog = "", morph = Npcs.SRARACHA_2143, petName = "Sraracha"),
    IKKLE_HYDRA(pet = Items.IKKLE_HYDRA, dialog = "", morph = Npcs.IKKLE_HYDRA_8492, petName = "Ikkle Hydra"),
    VORKI(pet = Items.VORKI, dialog = "", morph = Npcs.VORKI_8025, petName = "Vorki"),
    NOON(pet = Items.NOON, dialog = "", morph = Npcs.NOON_7891, petName = "Noon"),
    JAL_NIB_REK(pet = Items.JALNIBREK, dialog = "", morph = Npcs.JALNIBREK_7674, petName = "Jal-nib-rek"),
    SKOTOS(pet = Items.SKOTOS, dialog = "", morph = Npcs.SKOTOS_7671, petName = "Skotos"),
    ABYSSAL_ORPHAN(pet = Items.ABYSSAL_ORPHAN, dialog = "", morph = Npcs.ABYSSAL_ORPHAN_5883, petName = "Abyssal Orphan"),
    HELLPUPPY(pet = Items.HELLPUPPY, dialog = "", morph = Npcs.HELLPUPPY_3099, petName = "Hellpuppy"),
    TZREK_JAD(pet = Items.TZREKJAD, dialog = "", morph = Npcs.TZREKJAD_5892, petName = "Tzrek-jad"),
    SCOPRIA_OFFSPRING(pet = Items.SCORPIAS_OFFSPRING, dialog = "", morph = Npcs.SCORPIAS_OFFSPRING_5547, petName = "Scorpia's Offspring"),
    VETION_JR(pet = Items.VETION_JR, dialog = "", morph = Npcs.VETION_JR_5536, petName = "Vet'ion Jr.'"),
    CALLISTO_CUB(pet = Items.CALLISTO_CUB, dialog = "", morph = Npcs.CALLISTO_CUB_497, petName = "Callisto Cub"),
    VENENATIS_SPIDERLING(pet = Items.VENENATIS_SPIDERLING, dialog = "", morph = Npcs.VENENATIS_SPIDERLING_495, petName = "Venenatis Spiderling"),
    PET_SNAKELING(pet = Items.PET_SNAKELING, dialog = "", morph = Npcs.SNAKELING_2131, petName = "Pet Snakeling"),
    DARK_CORE(pet = Items.PET_DARK_CORE, dialog = "", morph = Npcs.DARK_CORE, petName = "Pet dark core"),
    PET_KRAKEN(pet = Items.PET_KRAKEN, dialog = "", morph = Npcs.KRAKEN_6640, petName = "Pet kraken"),
    PET_SMOKE_DEVIL(pet = Items.PET_SMOKE_DEVIL, dialog = "", morph = Npcs.SMOKE_DEVIL_8482, petName = "Pet smoke devil"),
    KALPHITE_PRINCESS(pet = Items.KALPHITE_PRINCESS, dialog = "", morph = Npcs.KALPHITE_PRINCESS_6637, petName = "Kalphite Princess"),
    PRINCE_BLACK_DRAGON(pet = Items.PRINCE_BLACK_DRAGON, dialog = "", morph = Npcs.PRINCE_BLACK_DRAGON_6636, petName = "Prince black dragen"),
    BABY_MOLE(pet = Items.BABY_MOLE, dialog = "", morph = Npcs.BABY_MOLE_6651, petName = "Baby mole"),
    GENERAL_GRAADOR(pet = Items.PET_GENERAL_GRAARDOR, dialog = "", morph = Npcs.GENERAL_GRAARDOR_JR, petName = "General graador Jr."),
    ZILYANA(pet = Items.PET_ZILYANA, dialog = "", morph = Npcs.ZILYANA_JR, petName = "Zilyana Jr."),
    TSUTSAROTH(pet = Items.PET_KRIL_TSUTSAROTH, dialog = "", morph = Npcs.KRIL_TSUTSAROTH_JR, petName = "K'ril tsutsaroth Jr."),
    KREE_ARRA(pet = Items.PET_KREEARRA, dialog = "", morph = Npcs.KREEARRA_JR, petName = "Kree'arra Jr."),
    PENANCE_QUEEN(pet = Items.PET_PENANCE_QUEEN, dialog = "", morph = Npcs.PENANCE_PET, petName = "Penance queen"),
    DAGANNOTH_REX(pet = Items.PET_DAGANNOTH_REX, dialog = "", morph = Npcs.DAGANNOTH_REX_JR, petName = "Dagannoth rex Jr."),
    DAGANNOTH_PRIME(pet = Items.PET_DAGANNOTH_PRIME, dialog = "", morph = Npcs.DAGANNOTH_PRIME_JR, petName = "Dagannoth prime Jr."),
    DAGANNOTH_SUPREME(pet = Items.PET_DAGANNOTH_SUPREME, dialog = "", morph = Npcs.DAGANNOTH_SUPREME_JR, petName = "Dagannoth supreme Jr."),
    CHAOS_ELEMENTAL(pet = Items.PET_CHAOS_ELEMENTAL, dialog = "", morph = Npcs.CHAOS_ELEMENTAL_JR, petName = "Chaos elemental Jr."),

    // Skilling pets
    HERBI(pet = Items.HERBI, dialog = "", morph = Npcs.HERBI_7759, petName = "Herbi"),
    PHOENIX(pet = Items.PHOENIX, dialog = "", morph = Npcs.PHOENIX_7368, petName = "Phoenix"),
    ROCKY(pet = Items.ROCKY, dialog = "", morph = Npcs.ROCKY_7336, petName = "Rocky"),
    RIFT_GUARDIAN(pet = Items.RIFT_GUARDIAN, dialog = "", morph = Npcs.RIFT_GUARDIAN_7337, petName = "Rift guardian"),
    TANGLEROOT(pet = Items.TANGLEROOT, dialog = "", morph = Npcs.TANGLEROOT_7335, petName = "Tangleroot"),
    SQUIRREL(pet = Items.GIANT_SQUIRREL, dialog = "", morph = Npcs.GIANT_SQUIRREL_7334, petName = "Giant squirrel"),
    BLOODHOUND(pet = Items.BLOODHOUND, dialog = "", morph = Npcs.BLOODHOUND_6296, petName = "Bloodhound"),
    CHINCHOMPA(pet = Items.BABY_CHINCHOMPA, dialog = "", morph = Npcs.BABY_CHINCHOMPA_6718, petName = "Baby chinchompa"),
    BEAVER(pet = Items.BEAVER, dialog = "", morph = Npcs.BEAVER_6717, petName = "Beaver"),
    ROCK_GOLEM(pet = Items.ROCK_GOLEM, dialog = "", morph = Npcs.ROCK_GOLEM_2182, petName = "Rock golem"),
    HERON(pet = Items.HERON, dialog = "", morph = Npcs.HERON_6715, petName = "Heron"),
    CHOMPY_CHICK(pet = Items.CHOMPY_CHICK, dialog = "", morph = Npcs.CHOMPY_CHICK_4001, petName = "Chompy chick");

    companion object {
        val values = enumValues<Pets>()
    }
}