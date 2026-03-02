{
  "type": "minecraft:chest",
  "pools": [
    {
      "rolls": {
        "min": 3,
        "max": 6
      },
      "entries": [
        {
          "type": "minecraft:item",
          "name": "minecraft:golden_carrot",
          "weight": 1,
          "functions": [
            {
              "function": "minecraft:set_count",
              "count": {
                "min": 4,
                "max": 8
              }
            }
          ]
        },
        {
          "type": "minecraft:item",
          "name": "minecraft:crossbow",
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
          "name": "minecraft:arrow",
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
          "name": "minecraft:emerald",
          "weight": 1,
          "functions": [
            {
              "function": "minecraft:set_count",
              "count": {
                "min": 3,
                "max": 12
              }
            }
          ]
        },
        {
          "type": "minecraft:item",
          "name": "minecraft:map",
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
        }
      ]
    }
  ],
  "random_sequence": "minecraft:chests/wc"
}
