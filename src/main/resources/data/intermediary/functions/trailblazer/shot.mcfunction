# from: player/main
# @s: player firing trailblazer

scoreboard players operation $trailblazer in.dummy = @s tr.ch

execute if entity @s store result score $power in.dummy run data get entity @s SelectedItem.tag.Enchantments[{id:"minecraft:power"}].lvl 10
execute if entity @s store result score $power in.dummy run data get entity @s Inventory[{Slot:-106b}].tag.Enchantments[{id:"minecraft:power"}].lvl 10

execute if entity @s[scores={tr.ch=15..}] as @e[type=#arrows,tag=!in.checked,distance=..3] run function intermediary:trailblazer/arrow/init

execute unless entity @s[scores={tr.ch=15..}] run function incendium:item/trailblazer/fail
