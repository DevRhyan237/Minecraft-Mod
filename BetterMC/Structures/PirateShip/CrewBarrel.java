{
  "type": "minecraft:block",
  "pools": [
    {
      "rolls": {
        "min": 4,
        "max": 8
      },
      "entries": [
        {
          "type": "minecraft:item",
          "name": "minecraft:string",
          "weight": 1,
          "functions": [
            {
              "function": "minecraft:set_count",
              "count": {
                "min": 4,
                "max": 16
              }
            }
          ]
        },
        {
          "type": "minecraft:item",
          "name": "minecraft:cobblestone",
          "weight": 1,
          "functions": [
            {
              "function": "minecraft:set_count",
              "count": {
                "min": 8,
                "max": 32
              }
            }
          ]
        },
        {
          "type": "minecraft:item",
          "name": "minecraft:stick",
          "weight": 1,
          "functions": [
            {
              "function": "minecraft:set_count",
              "count": {
                "min": 8,
                "max": 24
              }
            }
          ]
        },
        {
          "type": "minecraft:item",
          "name": "minecraft:rail",
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
          "name": "minecraft:tnt_minecart",
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
          "name": "minecraft:arrow",
          "weight": 1,
          "functions": [
            {
              "function": "minecraft:set_count",
              "count": {
                "min": 16,
                "max": 24
              }
            }
          ]
        },
        {
          "type": "minecraft:item",
          "name": "minecraft:gold_nugget",
          "weight": 1,
          "functions": [
            {
              "function": "minecraft:set_count",
              "count": {
                "min": 16,
                "max": 32
              }
            }
          ]
        }
      ]
    }
  ],
  "random_sequence": "minecraft:blocks/crew_barrel"
}
