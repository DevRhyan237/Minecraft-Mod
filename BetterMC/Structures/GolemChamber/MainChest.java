{
  "type": "minecraft:block",
  "pools": [
    {
      "rolls": 1,
      "entries": [
        {
          "type": "minecraft:item",
          "name": "minecraft:emerald",
          "weight": 2,
          "functions": [
            {
              "function": "minecraft:set_count",
              "count": {
                "min": 2,
                "max": 3
              }
            }
          ]
        }
      ]
    },
    {
      "rolls": 1,
      "entries": [
        {
          "type": "minecraft:item",
          "name": "minecraft:diamond_block",
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
        }
      ]
    },
    {
      "rolls": 1,
      "entries": [
        {
          "type": "minecraft:item",
          "name": "minecraft:cake",
          "weight": 1,
          "functions": [
            {
              "function": "minecraft:set_count",
              "count": {
                "min": 1,
                "max": 1
              }
            },
            {
              "function": "minecraft:enchant_with_levels",
              "levels": {
                "min": 1,
                "max": 2
              }
            }
          ]
        }
      ]
    },
    {
      "rolls": 1,
      "entries": [
        {
          "type": "minecraft:item",
          "name": "minecraft:diamond_chestplate",
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
                "max": 4
              }
            }
          ]
        }
      ]
    },
    {
      "rolls": 1,
      "entries": [
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
                "min": 1,
                "max": 3
              }
            }
          ]
        }
      ]
    },
    {
      "rolls": 1,
      "entries": [
        {
          "type": "minecraft:item",
          "name": "minecraft:mojang_banner_pattern",
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
        }
      ]
    },
    {
      "rolls": 1,
      "entries": [
        {
          "type": "minecraft:item",
          "name": "minecraft:sentry_armor_trim_smithing_template",
          "weight": 1,
          "functions": [
            {
              "function": "minecraft:set_count",
              "count": {
                "min": 2,
                "max": 3
              }
            }
          ]
        }
      ]
    },
    {
      "rolls": 1,
      "entries": [
        {
          "type": "minecraft:item",
          "name": "betterminecraft:sentry_boulder",
          "weight": 2,
          "functions": [
            {
              "function": "minecraft:set_count",
              "count": {
                "min": 2,
                "max": 3
              }
            }
          ]
        }
      ]
    },
    {
      "rolls": {
        "min": 0,
        "max": 1
      },
      "entries": [
        {
          "type": "minecraft:item",
          "name": "betterminecraft:platinum_ingot",
          "weight": 1,
          "functions": [
            {
              "function": "minecraft:set_count",
              "count": {
                "min": 0,
                "max": 2
              }
            }
          ]
        }
      ]
    },
    {
      "rolls": 1,
      "entries": [
        {
          "type": "minecraft:item",
          "name": "betterminecraft:backpack_item",
          "weight": 1,
          "functions": [
            {
              "function": "minecraft:set_count",
              "count": {
                "min": 1,
                "max": 1
              }
            }
          ]
        }
      ]
    },
    {
      "rolls": 1,
      "entries": [
        {
          "type": "minecraft:item",
          "name": "betterminecraft:muffin_food",
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
        }
      ]
    }
  ],
  "random_sequence": "minecraft:gmc"
}
