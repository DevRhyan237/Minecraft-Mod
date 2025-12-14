{
  "name": "betterminecraft:walker_outpost",
  "fallback": "minecraft:empty",
  "elements": [
    {
      "weight": 1,
      "element": {
        "element_type": "minecraft:single_pool_element",
        "location": "betterminecraft:walker_outpost",
        "projection": "rigid",
        "processors": {
          "processors": [
            {
              "processor_type": "minecraft:block_ignore",
              "blocks": [
                {
                  "Name": "minecraft:structure_block"
                }
              ]
            }
          ]
        }
      }
    }
  ]
}
