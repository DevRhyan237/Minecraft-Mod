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
                "max": 12
              }
            }
          ]
        },
        {
          "type": "minecraft:item",
          "name": "minecraft:gunpowder",
          "weight": 1,
          "functions": [
            {
              "function": "minecraft:set_count",
              "count": {
                "min": 2,
                "max": 16
              }
            }
          ]
        },
        {
          "type": "minecraft:item",
          "name": "betterminecraft:throwablecoconut",
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
          "name": "betterminecraft:orange",
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
        }
      ]
    }
  ],
  "random_sequence": "minecraft:blocks/wb"
}
