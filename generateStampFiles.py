import json

print("Generating stamp files")

stamps = [
  "axe_head",
  "excavator_head",
  "hammer_head",
  "kama_head",
  "knife_blade",
  "pick_head",
  "shovel_head",
  "sword_blade",
  "wide_guard"
]

for stamp in stamps:
  with open('src/main/resources/assets/emberstoolbox/models/item/stamp_%s.json' % stamp, 'w') as outfile:
      data = {
        "parent": "item/generated",
        "textures": {
          "layer0": "emberstoolbox:items/stamp_%s" % stamp
        }
      }
      json.dump(data, outfile, indent=2)

print("Done!")
