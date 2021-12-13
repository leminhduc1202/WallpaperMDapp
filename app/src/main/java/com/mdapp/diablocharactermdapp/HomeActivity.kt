package com.mdapp.diablocharactermdapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.*
import com.mdapp.diablocharactermdapp.adapter.Adapter
import com.mdapp.diablocharactermdapp.model.Items

class HomeActivity : AppCompatActivity(), AdapterView.OnItemClickListener {

    private var arrayList: ArrayList<Items>? = null
    private var gridView: GridView? = null
    private var adapter00: Adapter? = null

    lateinit var mAdView: AdView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        MobileAds.initialize(this) {}

        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        mAdView.adListener = object: AdListener() {
            override fun onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                Log.d("====", "onAdLoaded")
            }

            override fun onAdFailedToLoad(adError : LoadAdError) {
                // Code to be executed when an ad request fails.
                Log.d("====", adError.message)
            }

            override fun onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
                Log.d("====", "onAdOpened")
            }

            override fun onAdClicked() {
                // Code to be executed when the user clicks on an ad.
                Log.d("====", "onAdClicked")
            }

            override fun onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
                Log.d("====", "onAdClosed")
            }
        }

        gridView = findViewById(R.id.gv_body)
        arrayList = ArrayList()
        arrayList = setDataList()
        adapter00 = Adapter(applicationContext, arrayList!!)
        gridView?.adapter = adapter00
        gridView?.onItemClickListener = this

        var changeView = findViewById<Button>(R.id.change_view)
        changeView.setOnClickListener {
            val intent = Intent(this, WallpaperActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setDataList(): ArrayList<Items> {
        var arrayList: ArrayList<Items> = ArrayList()

        val path1 = "android.resource://" + packageName + "/" + R.raw.vd_barbarian
        val path2 = "android.resource://" + packageName + "/" + R.raw.vd_amazon
        val path3 = "android.resource://" + packageName + "/" + R.raw.vd_druid
        val path4 = "android.resource://" + packageName + "/" + R.raw.vd_assassin
        val path5 = "android.resource://" + packageName + "/" + R.raw.vd_paladin
        val path6 = "android.resource://" + packageName + "/" + R.raw.vd_necromancer1
        val path7 = "android.resource://" + packageName + "/" + R.raw.vd_sorceress

        arrayList.add(
            Items(
                R.drawable.barbarian,
                "Barbarian",
                "BARBARIAN\n" +
                        "If you prefer getting up close and personal, swinging your sword or axe while screaming in the faces of your enemies, then the Barbarian is for you. Mastering items, frantic combat skills, and shouting at the top of your lungs are a considerable part of your arsenal, but the Barbarian’s primary job is to soak up all the damage and be a big distraction to enable your allies to attack without worrying about getting hurt.\n" +
                        "\n" +
                        "Speaking of the best Diablo 2 Resurrected Barbarian build, the ‘Whirlwind’ skill combined with Battle Orders and Shout makes this one of the tankier builds in the game. So long as you use the Whirlwind in short bursts, you’ll be able to dish out the maximum amount of damage possible. While the Barbarian doesn’t do as much damage as the Paladin or Sorceress, he provides enough of a distraction that is vital for parties playing in multiplayer.\n" +
                        "\n" +
                        "BARBARIAN STARTING ATTRIBUTES\n" +
                        "-Health points – 55\n" +
                        "-Stamina – 92\n" +
                        "-Mana points – 10\n" +
                        "-Strength – 30\n" +
                        "-Dexterity – 20\n" +
                        "-Vitality – 25\n" +
                        "-Energy – 10\n" +
                        "BARBARIAN LEVEL UP STATS\n" +
                        "-Health points: +2\n" +
                        "-Stamina: +1\n" +
                        "-Mana: +1\n" +
                        "BARBARIAN ATTRIBUTE POINT EFFECTS\n" +
                        "-1x Vitality point = +4 health points and +1 stamina\n" +
                        "-1x Energy point = +1 mana point\n" +
                        "BARBARIAN COMBAT SKILLS\n" +
                        "-Bash – attacks an enemy and knocks them back\n" +
                        "-Double Swing – attacks with both weapons, striking two enemies at once\n" +
                        "-Leap – jump into the air, knocking back any foes at your landing point\n" +
                        "-Double Throw – throws both weapons outwards\n" +
                        "-Stun – strike an enemy, temporarily stuning them\n" +
                        "-Leap Attack – leap at an enemy, striking them as you land and knocking back surround foes\n" +
                        "-Concentrate – attacks an enemy and raises concentration, temporarily increasing defence\n" +
                        "-Frenzy – every successful hit increases velocity and attack speed\n" +
                        "-Whirlwind – the Barbarian spins his weapons around him, striking everything in his path\n" +
                        "-Berserk – a powerful attack that leaves the Barbarian more vulnerable\n" +
                        "BARBARIAN COMBAT MASTERIES\n" +
                        "-Sword Mastery – increases damage and attack rating when using swords\n" +
                        "-Axe Mastery – increases damage and attack rating when using axes (applies to throwing axes if used as melee weapons)\n" +
                        "-Mace Mastery – increases damage and attack rating when using maces\n" +
                        "-Polearm Mastery – increases damage and attack rating when using polearms\n" +
                        "-Throwing Mastery – increases damage and attack rating when throwing a weapon (benefits thrown axes and spears)\n" +
                        "-Spear Mastery – increases damage and attack rating when using spears (benefits throwing spears if used as melee weapons)\n" +
                        "-Increased Stamina – increases stamina and stamina recovery rate\n" +
                        "-Iron Skin – improves overall defence (Does not with Shout, Defiance, or Berserk skills, or the Conviction debuff)\n" +
                        "-Increased Speed – increases walk and run speeds (This stacks with speed boosts from items)\n" +
                        "-Natural Resistance – increases resistances to fire, cold, lightning, and poison damage\n" +
                        "BARBARIAN WARCRIES\n" +
                        "-Howl – frightens monsters, causing them to run in fear\n" +
                        "-Find Potion – Barbarian has a chance to procure a potion depending on a monster’s corpse (potion type depends on act)\n" +
                        "-Shout – increases the defence of allies\n" +
                        "-Taunt – taunts a monster, compelling it to engage in melee combat with reduced damage\n" +
                        "-Find Item – attempts to find a random item in a monster’s corpse\n" +
                        "-Battle Cry – lowers the nearby opponent’s defence and damage\n" +
                        "-Battle Orders – increases nearby allies’ life, stamina, and mana\n" +
                        "-Grim Ward – turns a corpse into a gruesome ward, causing nearby monsters to flee at the sight of it\n" +
                        "-War Cry – damages and stuns enemies\n" +
                        "-Battle Command – increases the Barbarian’s and nearby allies’ skills by one ",
                path1
            )
        )
        arrayList.add(
            Items(
                R.drawable.amazon,
                "Amazon",
                "AMAZON\n" +
                        "The Amazon is a highly versatile class in Diablo 2. They are simultaneously the class that fire arrows, and either stabs enemies with spears or use them as javelins. In addition, she can imbue her arrows with fire or cold elements and conjure potentially infinite arrows with other magical effects.\n" +
                        "\n" +
                        "Her versatility makes her a bit harder to use for newer players, but her best builds are competitive compared to the rest of the classes. If you fancy a bit of a challenge in your next Diablo 2 campaign run, then the Amazon is a decent class to try out.\n" +
                        "\n" +
                        "AMAZON STARTING ATTRIBUTES\n" +
                        "-Health points – 50\n" +
                        "-Stamina – 84\n" +
                        "-Mana points – 15\n" +
                        "-Strength – 20\n" +
                        "-Dexterity – 25\n" +
                        "-Vitality – 20\n" +
                        "-Energy – 15\n" +
                        "AMAZON LEVEL UP STATS\n" +
                        "-Health points: +2\n" +
                        "-Stamina: +1\n" +
                        "-Mana: +1.5\n" +
                        "AMAZON ATTRIBUTE POINT EFFECTS\n" +
                        "-1x Vitality point = +3 health points and +1 stamina\n" +
                        "-1x Energy point = +1.5 mana points\n" +
                        "AMAZON BOW AND CROSSBOW SKILLS\n" +
                        "-Magic Arrow – attacks with a magical arrow or bolt\n" +
                        "-Fire Arrow – enchants an arrow with fire, allowing it to deal additional magic damage\n" +
                        "-Cold Arrow – enchants an arrow with cold, adding cold damage and slowing your enemy\n" +
                        "-Multiple Shot – splits one arrow into many at reduced damage\n" +
                        "-Exploding Arrow – adds fire damage to normal arrows and explodes on impact\n" +
                        "-Ice Arrow – enchants arrows that deal additional cold damage and will temporarily freeze the target\n" +
                        "-Guided Arrow – imbues an arrow with the ability to seek its nearest target\n" +
                        "-Immolation Arrow – enchants an arrow with fire that explodes on contact, leaving a patch of fire\n" +
                        "-Strafe – fires a volley of arrows at multiple nearby targets\n" +
                        "-Freezing Arrow – enchants an arrow to deliver cold damage that freezes any monsters near the point of impact\n" +
                        "AMAZON PASSIVE AND MAGIC SKILLS\n" +
                        "-Inner Sight – illuminates foes and lowers their defences\n" +
                        "-Critical Strike – grants a chance to do double damage\n" +
                        "-Dodge – grants a chance to dodge melee attacks\n" +
                        "-Slow Missiles – slows the speed of incoming missile attacks\n" +
                        "-Avoid – grants a chance to move out of the way of a missile attack while standing still\n" +
                        "-Penetrate – improves attack, increasing your chance to hit\n" +
                        "-Decoy – creates a double, confusing foes\n" +
                        "-Evade – grants a chance to evade any attack while moving\n" +
                        "-Valkyrie – summons a powerful Valkyrie warrior to fight by your side\n" +
                        "-Pierce – grants a chance for your missile attacks to continue through its victim\n" +
                        "AMAZON JAVELIN AND SPEAR SKILLS\n" +
                        "-Jab – attack multiple times in succession, releasing a flurry of jabs\n" +
                        "-Power Strike – adds lightning damage and increases the weapon damage of thrusting attacks\n" +
                        "-Poison Javelin – causes thrown javelins to leave a trail of poison and deal extra poison damage\n" +
                        "-Impale – a powerful attack that reduces weapon durability\n" +
                        "-Lightning Bolt – causes a thrown javelin to leave a trail of lightning and hit for lightning damage\n" +
                        "-Charged Strike – upon striking an enemy, the Amazon’s javelin explodes with Charged Bolts\n" +
                        "-Plague Javelin – causes a thrown javelin to leave a trail of poison and a cloud on impact\n" +
                        "-Fend – rapidly strikes several close targets\n" +
                        "-Lightning Strike – strikes explode with Chain Lightning\n" +
                        "-Lightning Fury – creates a powerful lightning bolt that releases multiple lightning bolts from targets",
                path2
            )
        )
        arrayList.add(
            Items(
                R.drawable.druid,
                "Druid",
                "DRUID\n" +
                        "One of the two classes introduced initially in the Lord of Destruction expansion pack, the Druid specialises in using nature and body modifying skills to wade through the demons in his way. He can summon the elements to inflict damage, transform himself into a werewolf or werebear that he can give unique abilities to, or just summon creatures to fight by his side like ravens or oak sages. This is a good option for those wanting a mix of melee and ranged magical combat with average stats.\n" +
                        "\n" +
                        "We think that the best Diablo 2 Resurrected Druid build is his DPS focused ‘Fury Werewolf’ build. By channelling his inner beast, he can transform into a monster that has many buffs so long as he’s in beast mode. This is also a relatively varied build, with the option to call upon a grizzly bear to help manage crowds of enemies. If you have a Sorceress casting spells or a Paladin keeping you healthy, this class can be as good as the Barbarian.\n" +
                        "\n" +
                        "DRUID STARTING ATTRIBUTE\n" +
                        "-Health points – 55\n" +
                        "-Stamina – 84\n" +
                        "-Mana points – 20\n" +
                        "-Strength – 15\n" +
                        "-Dexterity – 20\n" +
                        "-Vitality – 25\n" +
                        "-Energy – 20\n" +
                        "DRUID LEVEL UP STATS\n" +
                        "-Health points: +1.5\n" +
                        "-Stamina: +1\n" +
                        "-Mana: +2\n" +
                        "DRUID ATTRIBUTE POINT EFFECTS\n" +
                        "-1x Vitality point = +2 health points and +1 stamina\n" +
                        "-1x Energy point = +2 mana points\n" +
                        "DRUID ELEMENTAL SKILLS\n" +
                        "-Firestorm – three weaving trails of fire that seek out enemies for a short distance\n" +
                        "-Molten Boulder – lunges a huge molten boulder at a group of foes\n" +
                        "-Arctic Blast – a spout of ice that freezes your enemies\n" +
                        "-Cyclone Armor – covers the Druid in protective forces that absorb elemental attacks\n" +
                        "-Fissure – attacks an area by opening a hole in the earth and damaging anything near it\n" +
                        "-Twister – summons three small twisters that deal damage and stun enemies\n" +
                        "-Volcano – creates a mini volcano that spurts out fireballs\n" +
                        "-Tornado – casts a larger whirlwind to damage your foes\n" +
                        "-Armageddon – small meteors fall from the sky around the Druid\n" +
                        "-Hurricane – manipulates a strong force of wind to surround the Druid\n" +
                        "-DRUID SHAPE-SHIFTING SKILLS\n" +
                        "-Werewolf – transforms the Druid into a Werewolf\n" +
                        "-Lycanthropy – increases the life of the Druid while shapeshifted, as well as the duration of the transformation\n" +
                        "-Werebear – transforms the Druid into a Werebear\n" +
                        "-Maul – mauls an enemy, building more strength with each hit\n" +
                        "-Feral Rage – leeches life from enemies, getting stronger with each attack\n" +
                        "-Fire Claws – augments your paws with fire damage\n" +
                        "-Rabies – toxifies your touch, poisoning anything you attack\n" +
                        "-Shock Wave – let loose a roar that stuns surrounding enemies\n" +
                        "-Hunger – attack an enemy, leeching both life and mana\n" +
                        "-Fury – viciously attack nearby enemies\n" +
                        "DRUID SUMMONING SKILLS\n" +
                        "-Raven – summon Ravens to peck out the eyes of your enemies\n" +
                        "-Poison Creeper – summons a poisonous vine that attacks enemies from underground\n" +
                        "-Oak Sage – summons a spirit that increases your party’s health\n" +
                        "-Summon Spirit Wolf – summons a Spirit Wolf to attack your enemies\n" +
                        "-Carrion Vine – summons a vine that eats corpses and gives the Druid life\n" +
                        "-Heart of Wolverine – summons a spirit to increase the party’s damage and attack rating\n" +
                        "-Summon Dire Wolf – summons a Dire Wolf to attack your enemies\n" +
                        "-Solar Creeper – summons a vine that consumes corpses and grants the Druid mana\n" +
                        "-Spirit of Barbs – summons a spirit that reflects damage back at attackers\n" +
                        "-Summon Grizzly – summons a Grizzly Bear to attack your enemies ",
                path3
            )
        )
        arrayList.add(
            Items(
                R.drawable.assassin,
                "Assassin",
                "ASSASSIN\n" +
                        "As the second of the two classes introduced initially in the Lord of Destruction expansion pack, the Assassin uses a mix of martial arts and deadly traps to take out targets. She’s also a master of ninja techniques, including rapid speed, allowing her to avoid enemy detection. Her stats are as average as they get, but she has impressive stamina that’s handy for avoiding danger.\n" +
                        "\n" +
                        "She’s also, sadly, the most challenging class to use in the game. It’s not that the best Diablo 2 Resurrected Assassin build isn’t good, it is, but her skills require the player to execute a lot of commands and set up traps in advance for her to be effective. Even her best build doesn’t quite reach the standards of the other classes as they’re just more efficient. If this doesn’t phase you, then it’s worth at least trying her out for yourself.\n" +
                        "\n" +
                        "ASSASSIN STARTING ATTRIBUTES\n" +
                        "-Health points – 50\n" +
                        "-Stamina – 95\n" +
                        "-Mana points – 25\n" +
                        "-Strength – 20\n" +
                        "-Dexterity – 20\n" +
                        "-Vitality – 20\n" +
                        "-Energy – 25\n" +
                        "ASSASSIN LEVEL UP STATS\n" +
                        "-Health points: +2\n" +
                        "-Stamina: +1.25\n" +
                        "-Mana: +1.5\n" +
                        "ASSASSIN ATTRIBUTE POINT EFFECTS\n" +
                        "-1x Vitality point = +3 health points and +1.25 stamina\n" +
                        "-1x Energy point = +1.75 mana points\n" +
                        "ASSASSIN MARTIAL ARTS\n" +
                        "-Tiger Strike – attacks an enemy and stores a charge\n" +
                        "-Dragon Talon – attacks an enemy with a flurry of kicks\n" +
                        "-Fists of Fire – a fire attack that deals more damage with each charge\n" +
                        "-Dragon Claw – attack an enemy with both weapons simultaneously\n" +
                        "-Cobra Strike – an attack that drains life and mana from the victim\n" +
                        "-Claws of Thunder – an attack that deals lightning damage and stores a charge\n" +
                        "-Dragon Tail – a powerful kick that explodes on impact\n" +
                        "-Blades of Ice – an attack that chills an enemy\n" +
                        "-Dragon Flight – teleports to an enemy and kicks it\n" +
                        "-Phoenix Strike – a finishing move that deals fire, lightning, and cold damage all at once\n" +
                        "ASSASSIN SHADOW DISCIPLINES\n" +
                        "-Claw Mastery – increases combat efficiency with claw-type weapons\n" +
                        "-Psychic Hammer – attacks an enemy with a mental blast\n" +
                        "-Burst of Speed – increases attack and movement speed for a short time\n" +
                        "-Cloak of Shadows – hides the Assassin, allowing her to attack with greater accuracy\n" +
                        "-Weapon Block – allows an Assassin to block when using two claw-type weapons\n" +
                        "-Fade – partially phases the Assassin to another plane, allowing her to avoid some magical attacks\n" +
                        "-Shadow Warrior – summons a ‘shadow’ of the Assassin to fight alongside her\n" +
                        "-Mind Blast – mentally attacks surrounding enemies, confusing some and stunning others\n" +
                        "-Venom – poisons the Assassin’s weapons\n" +
                        "-Shadow Master – calls upon a spectral shadow of the Assassin to aid in combat\n" +
                        "ASSASSIN TRAPS\n" +
                        "-Fire Blast – creates a small bomb the Assassin can throw\n" +
                        "-Shock Web – droips a small trap that deals lightning damage to anything nearby\n" +
                        "-Blade Sentinel – throws a razor-sharp blade that flies back and forth between the Assassin and her target\n" +
                        "-Charged Bolt Sentry – medium Assassin trap that fires Charged Bolt attacks\n" +
                        "-Wake of Fire – the Assassin drops a trap at her location that sends out small waves of fire around it, dealing damage to enemies caught in the waves\n" +
                        "-Blade Fury – fires a blade swiftly at an enemy\n" +
                        "-Lightning Sentry – drops a trap that shoots lightning at nearby foes\n" +
                        "-Wake of Inferno – drops a trap that shoots a large blast of fire\n" +
                        "-Death Sentry – drops a modified Lightning Sentry that uses the Necromancer’s Corpse Explosion skill\n" +
                        "-Blade Shield – covers the Assassin in a shield of small razors",
                path4
            )
        )
        arrayList.add(
            Items(
                R.drawable.paladin,
                "Paladin",
                "PALADIN \n + The Paladin can be either a highly offensive class able to power up the entire team or a defensive class that uses auras to give the team resistance to various types of attacks. He also uses magic attacks to inflict damage on foes or to heal and buff friends. He has among the highest health pool and strength stats and is excellent for those wanting to lean towards a support/tank build.\n" +
                        "\n" +
                        "However, where he truly shines is the best Diablo 2 Resurrected Paladin build: the ‘Hammerdin’. By using a lethal combination of auras, the Paladin’s Blessed Hammer skill can smite demons with ease, and his teammates get all the benefits of the auras to their attacks. If the Hammerdin is not to your tastes, several viable options are available, making it the most versatile class in the game.\n" +
                        "\n" +
                        "PALADIN STARTING ATTRIBUTES\n" +
                        "-Health points – 55\n" +
                        "-Stamina – 89\n" +
                        "-Mana points – 15\n" +
                        "-Strength – 25\n" +
                        "-Dexterity – 20\n" +
                        "-Vitality – 25\n" +
                        "-Energy – 15\n" +
                        "PALADIN LEVEL UP STATS\n" +
                        "-Health points: +2\n" +
                        "-Stamina: +1\n" +
                        "-Mana: +1.5\n" +
                        "PALADIN ATTRIBUTE POINT EFFECTS\n" +
                        "-1x Vitality point = +3 health points and +1 stamina\n" +
                        "-1x Energy point = +1.5 mana points\n" +
                        "PALADIN DEFENSIVE AURAS\n" +
                        "-Prayer – heals all party members at the expense of the caster’s mana reserves\n" +
                        "-Resist Fire – increases fire resistance for all party members\n" +
                        "-Defiance – boosts the defence of all party members\n" +
                        "-Resist Cold – increases cold resistance for all party members\n" +
                        "-Cleansing – reduces poison and curse duration for all party members\n" +
                        "-Resist Lightning – increases lightning resistance for all party members\n" +
                        "-Vigor – increases speed, stamina, and stamina recovery for all party members\n" +
                        "-Meditation – boosts mana recovery for all party members\n" +
                        "-Redemption – periodically attempts to redeem corpses for health and mana\n" +
                        "-Salvation – increases all elemental resistances for all party members\n" +
                        "PALADIN OFFENSIVE AURAS\n" +
                        "-Might – increases damage dealt by the Paladin and his allies\n" +
                        "-Holy Fire – periodically does fire damage to nearby enemies\n" +
                        "-Thorns – enemies take damage when they cause melee damage to party members\n" +
                        "-Blessed Aim – increases attack rating\n" +
                        "-Holy Freeze – periodically does cold damage to nearby enemies\n" +
                        "-Concentration – increases damage dealt and reduces the chance of being interrupted during an attack\n" +
                        "-Holy Shock – periodically does lightning damage to nearby enemies\n" +
                        "-Fanaticism – increases your damage, attack speed, and attack rating. Increases damage for all party members\n" +
                        "-Conviction – reduces enemy defence and resistances\n" +
                        "PALADIN COMBAT SKILLS\n" +
                        "-Sacrifice – increases damage at the cost of health\n" +
                        "-Smite – a shield bash that does damage and knockback\n" +
                        "-Holy Bolt – a bolt of energy that damages undead or heals friendly units\n" +
                        "-Zeal – quickly attacks multiple adjacent enemies\n" +
                        "-Charge – closes the distance with an enemy, delivering a bash on combat\n" +
                        "-Vengeance – adds elemental damage to all melee attacks (fire, lightning, and cold)\n" +
                        "-Blessed Hammer – summons a magic hammer that spirals outward, damaging enemies\n" +
                        "-Conversion – a successful attack has a chance to convert the target to fight for the Paladin\n" +
                        "-Holy Shield – magically enhances shield to give defensive bonuses\n" +
                        "-Fist of the Heavens – calls down a bolt of lightning on the target, then sends out a spray of Holy Bolts",
                path5
            )
        )
        arrayList.add(
            Items(
                R.drawable.necromancer,
                "Necromancer",
                "NECROMANCER\n" +
                        "The Necromancer excels at using macabre magic to raise a skeleton army and other minions to fight for you. But while he may be more well known for his many pets, the Necromancer does have other spells. He can use poison to sap at an opponent’s life, use bones as ingredients for magic, and even curse enemies with status ailments. He’s somewhat on the flimsy side but not the weakest of the bunch.\n" +
                        "\n" +
                        "Our recommendation for the best Diablo 2 Necromancer build focuses heavily on summoning his monster army. You’ll begin by investing in Raise Skeleton and Clay Golem to act as a barrier between your enemies and your allies. Then, you can use Corpse Explosion to wipe out large clusters of foes at once for every enemy that dies. If there is a mighty enemy you’ve just slain, the last skill, Revive, will bolster your army with a powerful new companion. The Necromancer’s ability to distract the enemy is valuable. The only issue with this strategy is that your allies in multiplayer might find it difficult to tell the difference between enemies and your monsters.\n" +
                        "\n" +
                        "NECROMANCER STARTING ATTRIBUTES\n" +
                        "-Health points – 45\n" +
                        "-Stamina – 79\n" +
                        "-Mana points – 25\n" +
                        "-Strength – 15\n" +
                        "-Dexterity – 25\n" +
                        "-Vitality – 15\n" +
                        "-Energy – 25\n" +
                        "NECROMANCER LEVEL UP STATS\n" +
                        "-Health points: +1.5\n" +
                        "-Stamina: +1\n" +
                        "-Mana: +2\n" +
                        "NECROMANCER ATTRIBUTE POINT EFFECTS\n" +
                        "-1x Vitality point = +2 health points and +1 stamina\n" +
                        "-1x Energy point = +2 mana points\n" +
                        "NECROMANCER SUMMONING SPELLS\n" +
                        "-Raising Skeleton – raise an undead warrior from a corpse to fight for you\n" +
                        "-Skeleton Mastery – improves the quality of raised Skeletons, Magi, and Revived\n" +
                        "-Clay Golem – raises a Golem from the earth to fight for you\n" +
                        "-Golem Mastery – enhances the speed and life of Golems\n" +
                        "-Raise Skeletal Mage – raises an undead mage to fight for you\n" +
                        "-Blood Golem – summons a golem made of your blood\n" +
                        "-Summon Resist – increases the resistances of your summoned minions\n" +
                        "-Iron Golem – summons a powerful Golem at the cost of a metal item. The Golem takes the properties of the sacrificed item\n" +
                        "-Fire Golem – summons a Golem of fire\n" +
                        "-Revive – resurrects a monster to fight for you\n" +
                        "NECROMANCER POISON AND BONE SPELLS\n" +
                        "-Teeth – summons multiple projectiles to damage enemies\n" +
                        "-Bone Armor – creates a protective shield of bone that absorbs damage from physical attacks\n" +
                        "-Poison Dagger – coats your weapon with a layer of poison\n" +
                        "-Corpse Explosion – fills a corpse with energy causing it to explode violently\n" +
                        "-Bone Wall – creates a barrier of bone\n" +
                        "-Poison Explosion – releases a cloud of poisonous gas from a corpse\n" +
                        "-Bone Spear – summons a bone missile that can damage and pass through multiple enemies\n" +
                        "-Bone Prison – summons a ring of bone to surround a target\n" +
                        "-Poison Nova – a ring of poison explodes from the Necromancer\n" +
                        "-Bone Spirit – summons a spirit to track and damage a target\n" +
                        "NECROMANCER CURSES\n" +
                        "-Amplify Damage – increases the amount of damage enemies recieve\n" +
                        "-Dim Vision – decreases the radius of vision for enemies\n" +
                        "-Weaken – decreases the damage dealt by enemies caught inside the curse\n" +
                        "-Iron Maiden – reflects damage back at attackers\n" +
                        "-Terror – causes monsters to run away in fear\n" +
                        "-Confuse – confuses monsters, causing them to attack randomly\n" +
                        "-Life Tap – curses an enemy, causing them to grant life to their attackers\n" +
                        "-Attract – causes other monsters to target your enemy\n" +
                        "-Decrepify – a crippling curse that halves enemy units’ speed, damage, and physical resistances\n" +
                        "-Lower Resist – elemental attacks do more damage to the cursed monster",
                path6
            )
        )
        arrayList.add(
            Items(
                R.drawable.sorceress,
                "Sorceress",
                "SORCERESS\n" +
                        "With mastery over ice, lightning, and fire, the Sorceress flings spells that can seriously damage foes, inflict status ailments, and protect from enemy attacks. However, she is the most fragile of all the classes and pretty terrible at melee combat too, but makes up for it with a massive mana pool.\n" +
                        "\n" +
                        "The best Diablo 2 Resurrected Sorceress build is just a smidge harder to use than the Paladin thanks to enemies with cold resistance, but flinging ‘Frozen Orbs’ to annihilate every enemy on-screen is immensely satisfying. The only thing that puts the Paladin above the Sorceress is that the Paladin has abilities that help everyone. On the other hand, the Sorceress doesn’t buff her teammates, but killing monsters is still a helpful contribution. So if you want to focus on raw DPS, the Sorceress is for you.\n" +
                        "\n" +
                        "SORCERESS STARTING ATTRIBUTES\n" +
                        "-Health points – 40\n" +
                        "-Stamina – 74\n" +
                        "-Mana points – 35\n" +
                        "-Strength – 10\n" +
                        "-Dexterity – 25\n" +
                        "-Vitality – 10\n" +
                        "-Energy – 35\n" +
                        "SORCERESS LEVEL UP STATS\n" +
                        "-Health points: +1\n" +
                        "-Stamina: +1\n" +
                        "-Mana: +2\n" +
                        "SORCERESS ATTRIBUTE POINT EFFECTS\n" +
                        "-1x Vitality point = +2 health points and +1 stamina\n" +
                        "-1x Energy point = +2 mana points\n" +
                        "SORCERESS FIRE SPELLS\n" +
                        "-Fire Bolt – creates a bolt of fire\n" +
                        "-Warmth – increases mana recovery rate\n" +
                        "-Inferno – creates a spout of flame that burns enemies\n" +
                        "-Fire Ball – creates a ball of fire that explodes on impact\n" +
                        "-Blaze – leave a wall of fire in your footsteps\n" +
                        "-Fire Wall – creates a wall of fire\n" +
                        "-Enchant – temporarily adds fire damage to a weapon\n" +
                        "-Meteor – summons a meteor from the heavens to smite enemies\n" +
                        "-Fire Mastery – increases damage done by all fire spells\n" +
                        "-Hydra – creates a multi-headed beast that attacks enemies with bolts of fire\n" +
                        "SORCERESS LIGHTNING SPELLS\n" +
                        "-Charged Bolt – fires multiple jumping bolts of electricity that seek their targets\n" +
                        "-Telekinesis – allows you to pick up items, attack, and trigger objects at a distance\n" +
                        "-Static Field – every enemy in a radius around you loses 25% of their current health\n" +
                        "-Lightning – casts a bolt of lightning\n" +
                        "-Nova – creates an expanding ring of electricity\n" +
                        "-Chain Lighting – casts a lightning bolt that jumps through multiple targets\n" +
                        "-Teleport – instantly transports you between two points\n" +
                        "-Thunder Storm – summons a thunderstorm that periodically blasts a nearby enemy with a bolt of lightning\n" +
                        "-Energy Shield – absorbs magical and some physical damage to damage your mana instead of life\n" +
                        "-Lighting Mastery – increases the damage of all lightning spells\n" +
                        "SORCERESS COLD SPELLS\n" +
                        "-Ice Bolt – shots a bolt of ice that damages and slows your victim\n" +
                        "-Frozen Armor – gives a defence bonus and freezes any melee attacker that hits you\n" +
                        "-Ice Blast – creates a bolt of ice that completely freezes a target\n" +
                        "-Frost Nova – creates an expanding ring of ice and frost that damages and slows enemies\n" +
                        "-Shiver Armor – enchants with an armor of cold, granting a defence bonus, while also slowing and damaging melee attackers\n" +
                        "-Glacial Spike – a shard of ice that inflicts massive cold damage and explodes to freeze nearby foes\n" +
                        "-Blizzard – summons an ice storm to rain cold death onto enemies\n" +
                        "-Chilling Armor – confers a defence bonus and launches an ice bolt against ranged attackers\n" +
                        "-Cold Mastery – pierces the cold resistance of your enemies\n" +
                        "-Frozen Orb – a pulsating orb that shreds an area with ice bolts",
                path7
            )
        )

        return arrayList
    }


    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        var itemss: Items = arrayList!!.get(p2)

        var intent = Intent(this, WallpaperHome::class.java)
        intent.putExtra("data", arrayList!![p2])
        startActivity(intent)

//        var intentDialog = Intent(this, DialogActivity::class.java)
//        intentDialog.putExtra("data", arrayList!![p2])
//        startActivity(intentDialog)
    }

}