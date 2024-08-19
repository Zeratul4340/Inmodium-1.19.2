# from ./using
# on_update

# calc cmd
scoreboard players operation $cmd in.dummy = @s tr.ch
scoreboard players operation $cmd in.dummy /= #2 in.constants
scoreboard players operation $cmd in.dummy *= #100 in.constants
scoreboard players add $cmd in.dummy 1450104

# # calc spd
# scoreboard players operation $zoom in.dummy = @s tr.ch
# scoreboard players operation $zoom in.dummy /= #2 in.constants

# SOUNDS
execute if entity @s[scores={tr.ch=20}] run playsound minecraft:block.respawn_anchor.charge master @a[distance=..16] ~ ~ ~ 1 0.65

execute if entity @s[scores={tr.ch=40}] run playsound minecraft:block.respawn_anchor.charge master @a[distance=..16] ~ ~ ~ 1 0.9

execute if entity @s[scores={tr.ch=60}] run playsound minecraft:block.respawn_anchor.charge master @a[distance=..16] ~ ~ ~ 1 1.4

execute if entity @s[scores={tr.ch=80}] run playsound minecraft:block.respawn_anchor.charge master @a[distance=..16] ~ ~ ~ 1 2

# ZOOM
effect give @s[scores={tr.ch=20}] slowness 2 1 true

effect give @s[scores={tr.ch=40}] slowness 2 3 true

effect give @s[scores={tr.ch=60}] slowness 2 5 true

effect give @s[scores={tr.ch=80}] slowness 2 7 true

execute store result storage incendium:temp bow.CustomModelData int 1 run scoreboard players get $cmd in.dummy

item modify entity @s[scores={tr.ch=40..}] weapon.mainhand incendium:trailblazer/update
item modify entity @s[scores={tr.ch=40..}] weapon.offhand incendium:trailblazer/update

tag @s add in.trailblazer_fix
