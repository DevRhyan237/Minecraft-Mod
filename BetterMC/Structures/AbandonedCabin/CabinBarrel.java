{
  "type": "minecraft:chest",
  "pools": [
    {
      "rolls": 1,
      "entries": [
        {
          "type": "minecraft:item",
          "name": "minecraft:string",
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
          "name": "minecraft:glow_berries",
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
                "max": 12
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
                "min": 2,
                "max": 4
              }
            }
          ]
        },
        {
          "type": "minecraft:item",
          "name": "minecraft:coal",
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
        }
      ]
    }
  ],
  "random_sequence": "minecraft:cb"
}
