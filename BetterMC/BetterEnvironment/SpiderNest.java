{
  "has_precipitation": true,
  "temperature": 0.5,
  "downfall": 0.5,
  "effects": {
    "additions_sound": {
      "sound": "block.pointed_dripstone.drip_water_into_cauldron",
      "tick_chance": 0.0111
    },
    "music": [
      {
        "weight": 1,
        "data": {
          "sound": "music.overworld.dripstone_caves",
          "min_delay": 12000,
          "max_delay": 24000,
          "replace_current_music": true
        }
      }
    ],
    "particle": {
      "options": {
        "type": "white_ash"
      },
      "probability": 0.005
    },
    "foliage_color": -6710887,
    "grass_color": -6710887,
    "sky_color": -6710887,
    "fog_color": -6710887,
    "water_color": -6710887,
    "water_fog_color": -6710887
  },
  "spawners": {
    "monster": [
      {
        "type": "spider",
        "weight": 20,
        "minCount": 1,
        "maxCount": 4
      },
      {
        "type": "cave_spider",
        "weight": 20,
        "minCount": 1,
        "maxCount": 4
      },
      {
        "type": "betterminecraft:spider_queen",
        "weight": 2,
        "minCount": 1,
        "maxCount": 1
      }
    ],
    "creature": [],
    "ambient": [],
    "axolotls": [],
    "underground_water_creature": [],
    "water_creature": [],
    "water_ambient": [],
    "misc": []
  },
  "spawn_costs": {},
  "carvers": [
    "minecraft:cave",
    "minecraft:cave_extra_underground",
    "minecraft:canyon"
  ],
  "features": [
    [],
    [
      "minecraft:lake_lava_underground"
    ],
    [
      "minecraft:amethyst_geode",
      "minecraft:forest_rock"
    ],
    [
      "minecraft:monster_room",
      "minecraft:monster_room_deep"
    ],
    [],
    [],
    [
      "minecraft:ore_coal_upper",
      "minecraft:ore_coal_lower",
      "minecraft:ore_iron_upper",
      "minecraft:ore_iron_middle",
      "minecraft:ore_iron_small",
      "minecraft:ore_gold",
      "minecraft:ore_gold_lower",
      "minecraft:ore_redstone",
      "minecraft:ore_redstone_lower",
      "minecraft:ore_diamond",
      "minecraft:ore_diamond_medium",
      "minecraft:ore_diamond_large",
      "minecraft:ore_diamond_buried",
      "minecraft:ore_lapis",
      "minecraft:ore_lapis_buried",
      "minecraft:ore_copper",
      "minecraft:underwater_magma",
      "minecraft:ore_emerald"
    ],
    [],
    [],
    [
      "betterminecraft:spider_nest_tree"
    ],
    []
  ]
}
