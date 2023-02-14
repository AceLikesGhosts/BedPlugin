# BedPlugin

a simple plugin that provides access to "/bed", which teleports you to your minecraft bed.

### commands:
1. /bed
	- permission: N/A
	- description: teleports you to your bed (or another player's given you have OP)
2. /encodeposition
	- permission: bedplugin.encodeposition
	- description: encodes your current position into one that the plugin can use (for config)

### config:
```yml
# WORLD_NAME@X@Y@Z@YAW@PITCH
# EX: WORLD_NAME@0@0@0@0@0 = 0 X 0 Y 0 Z 0 YAW 0 PITCH
# EX: WORLD_NAME@255@64@255@0@0 = 255 X 64 Y 255 Z 0 YAW 0 PITCH
defaultLocation: "world@0@0@0@0@0"
# should we tp them to default location? (instead of saying no bed)
# false = off
# true = on
useDefaultLocation: false
```

### licencing
this project is licenced using the [unlicence](https://unlicence.org) licence, or therefore lack of.
