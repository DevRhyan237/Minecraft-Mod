{
  "type": "minecraft:block",
  "pools": [
    {
      "rolls": {
        "min": 1,
        "max": 17
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
                "min": 1,
                "max": 4
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
                "min": 2,
                "max": 6
              }
            }
          ]
        },
        {
          "type": "minecraft:item",
          "name": "betterminecraft:palm_planks",
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
          "name": "minecraft:bamboo_mosaic",
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
          "name": "minecraft:sugar_cane",
          "weight": 1,
          "functions": [
            {
              "function": "minecraft:set_count",
              "count": {
                "min": 3,
                "max": 6
              }
            }
          ]
        }
      ]
    }
  ],
  "random_sequence": "minecraft:db/blocks"
}
