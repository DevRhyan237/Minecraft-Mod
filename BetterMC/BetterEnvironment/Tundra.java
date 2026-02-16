{
  "has_precipitation": true,
  "temperature": 0,
  "downfall": 0.5,
  "effects": {
    "ambient_sound": "betterminecraft:tundra_blizzard",
    "music": [
      {
        "weight": 1,
        "data": {
          "sound": "music.overworld.snowy_slopes",
          "min_delay": 12000,
          "max_delay": 24000,
          "replace_current_music": true
        }
      }
    ],
    "particle": {
      "options": {
        "type": "snowflake"
      },
      "probability": 0.0005
    },
    "foliage_color": -7149370,
    "grass_color": -7149370,
    "sky_color": -7149370,
    "fog_color": -7149370,
    "water_color": -7149370,
    "water_fog_color": -7149370
  },
  "spawners": {
    "monster": [
      {
        "type": "stray",
        "weight": 20,
        "minCount": 1,
        "maxCount": 4
      },
      {
        "type": "rabbit",
        "weight": 5,
        "minCount": 1,
        "maxCount": 4
      },
      {
        "type": "wolf",
        "weight": 2,
        "minCount": 1,
        "maxCount": 4
      }
    ],
    "creature": [
      {
        "type": "polar_bear",
        "weight": 10,
        "minCount": 1,
        "maxCount": 2
      }
    ],
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
      "minecraft:forest_rock"
    ],
    [],
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
      "minecraft:underwater_magma"
    ],
    [],
    [],
    [],
    [
      "minecraft:freeze_top_layer"
    ]
  ]
}
