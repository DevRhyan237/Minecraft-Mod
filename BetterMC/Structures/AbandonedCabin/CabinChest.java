{
  "type": "minecraft:chest",
  "pools": [
    {
      "rolls": 1,
      "entries": [
        {
          "type": "minecraft:item",
          "name": "minecraft:oak_planks",
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
          "name": "minecraft:stick",
          "weight": 1,
          "functions": [
            {
              "function": "minecraft:set_count",
              "count": {
                "min": 5,
                "max": 20
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
                "min": 1,
                "max": 1
              }
            },
            {
              "function": "minecraft:enchant_with_levels",
              "levels": {
                "min": 0,
                "max": 1
              }
            }
          ]
        },
        {
          "type": "minecraft:item",
          "name": "minecraft:chain",
          "weight": 1,
          "functions": [
            {
              "function": "minecraft:set_count",
              "count": {
                "min": 3,
                "max": 8
              }
            }
          ]
        },
        {
          "type": "minecraft:item",
          "name": "minecraft:torch",
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
        }
      ]
    }
  ],
  "random_sequence": "minecraft:cc"
}
