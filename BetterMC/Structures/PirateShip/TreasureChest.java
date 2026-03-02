{
  "type": "minecraft:chest",
  "pools": [
    {
      "rolls": {
        "min": 4,
        "max": 8
      },
      "entries": [
        {
          "type": "minecraft:item",
          "name": "betterminecraft:piratedisc",
          "weight": 1,
          "functions": [
            {
              "function": "minecraft:set_count",
              "count": {
                "min": 0,
                "max": 1
              }
            }
          ]
        },
        {
          "type": "minecraft:item",
          "name": "betterminecraft:cannon",
          "weight": 1,
          "functions": [
            {
              "function": "minecraft:set_count",
              "count": {
                "min": 0,
                "max": 1
              }
            }
          ]
        },
        {
          "type": "minecraft:item",
          "name": "minecraft:emerald",
          "weight": 1,
          "functions": [
            {
              "function": "minecraft:set_count",
              "count": {
                "min": 8,
                "max": 16
              }
            }
          ]
        },
        {
          "type": "minecraft:item",
          "name": "minecraft:diamond_sword",
          "weight": 1,
          "functions": [
            {
              "function": "minecraft:set_count",
              "count": {
                "min": 0,
                "max": 1
              }
            },
            {
              "function": "minecraft:enchant_with_levels",
              "levels": {
                "min": 0,
                "max": 5
              }
            }
          ]
        },
        {
          "type": "minecraft:item",
          "name": "minecraft:iron_pickaxe",
          "weight": 1,
          "functions": [
            {
              "function": "minecraft:set_count",
              "count": {
                "min": 0,
                "max": 1
              }
            },
            {
              "function": "minecraft:enchant_with_levels",
              "levels": {
                "min": 0,
                "max": 5
              }
            }
          ]
        },
        {
          "type": "minecraft:item",
          "name": "minecraft:golden_apple",
          "weight": 1,
          "functions": [
            {
              "function": "minecraft:set_count",
              "count": {
                "min": 2,
                "max": 4
              }
            }
          ]
        },
        {
          "type": "minecraft:item",
          "name": "betterminecraft:banana",
          "weight": 1,
          "functions": [
            {
              "function": "minecraft:set_count",
              "count": {
                "min": 8,
                "max": 16
              }
            }
          ]
        },
        {
          "type": "minecraft:item",
          "name": "betterminecraft:rope",
          "weight": 1,
          "functions": [
            {
              "function": "minecraft:set_count",
              "count": {
                "min": 4,
                "max": 12
              }
            }
          ]
        },
        {
          "type": "minecraft:item",
          "name": "minecraft:skeleton_skull",
          "weight": 1,
          "functions": [
            {
              "function": "minecraft:set_count",
              "count": {
                "min": 1,
                "max": 2
              }
            }
          ]
        }
      ]
    }
  ],
  "random_sequence": "minecraft:chests/treasure_chest"
}
