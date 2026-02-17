{
  "type": "minecraft:chest",
  "pools": [
    {
      "rolls": {
        "min": 12,
        "max": 16
      },
      "entries": [
        {
          "type": "minecraft:item",
          "name": "minecraft:gold_ingot",
          "weight": 1,
          "functions": [
            {
              "function": "minecraft:set_count",
              "count": {
                "min": 1,
                "max": 4
              }
            }
          ]
        },
        {
          "type": "minecraft:item",
          "name": "minecraft:iron_ingot",
          "weight": 1,
          "functions": [
            {
              "function": "minecraft:set_count",
              "count": {
                "min": 1,
                "max": 6
              }
            }
          ]
        },
        {
          "type": "minecraft:item",
          "name": "minecraft:cooked_beef",
          "weight": 1,
          "functions": [
            {
              "function": "minecraft:set_count",
              "count": {
                "min": 2,
                "max": 8
              }
            }
          ]
        },
        {
          "type": "minecraft:item",
          "name": "minecraft:iron_sword",
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
                "min": 1,
                "max": 3
              }
            }
          ]
        },
        {
          "type": "minecraft:item",
          "name": "minecraft:iron_chestplate",
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
                "max": 4
              }
            }
          ]
        },
        {
          "type": "minecraft:item",
          "name": "minecraft:iron_helmet",
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
                "max": 4
              }
            }
          ]
        },
        {
          "type": "minecraft:item",
          "name": "minecraft:iron_leggings",
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
                "max": 4
              }
            }
          ]
        },
        {
          "type": "minecraft:item",
          "name": "minecraft:iron_boots",
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
                "max": 4
              }
            }
          ]
        },
        {
          "type": "minecraft:item",
          "name": "minecraft:shield",
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
          "name": "betterminecraft:rope",
          "weight": 1,
          "functions": [
            {
              "function": "minecraft:set_count",
              "count": {
                "min": 0,
                "max": 6
              }
            }
          ]
        }
      ]
    }
  ],
  "random_sequence": "minecraft:dc/chests"
}
