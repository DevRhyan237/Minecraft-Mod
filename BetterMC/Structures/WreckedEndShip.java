{
  "name": "betterminecraft:wrecked_end_ship",
  "fallback": "minecraft:empty",
  "elements": [
    {
      "weight": 1,
      "element": {
        "element_type": "minecraft:single_pool_element",
        "location": "betterminecraft:wrecked_end_ship",
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
