# trailblazer
execute unless score @s in.wet matches -2147483647.. run scoreboard players set @s in.wet 0
execute if entity @s[tag=tr.ch_fix,scores={tr.ch=0} run function incendium:item/trailblazer/fix
execute if entity @s[scores={in.wet=..0,in.use_bow=1..} run function incendium:item/trailblazer/shot
execute if entity @s[scores={in.wet=..0,tr.ch=1..}, advancements={incendium:technical/using/trailblazer=false}] run function incendium:item/trailblazer/on_unload
execute if entity @s[scores={in.wet=..0},advancements={incendium:technical/using/trailblazer=true}] run function incendium:item/trailblazer/using
execute if entity @s[scores={in.wet=1..},advancements={incendium:technical/using/trailblazer=true}] run function incendium:item/trailblazer/using/while_wet

# trailblazer
execute if entity @s[type=#arrows,tag=in.trailblazer] run function incendium:item/trailblazer/arrow/main