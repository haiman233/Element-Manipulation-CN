package me.lucasgithuber.elementmanipulation.machines;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.RecipeDisplayItem;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.implementation.operations.CraftingOperation;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.lucasgithuber.elementmanipulation.elements.Elements;
import me.lucasgithuber.elementmanipulation.misc.Analisis;
import me.lucasgithuber.elementmanipulation.gui.RockAnalyzerGui;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.MachineRecipe;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RockAnalyzer extends RockAnalyzerGui implements RecipeDisplayItem {

    public RockAnalyzer(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Nonnull
    @Override
    public List < ItemStack > getDisplayRecipes() {
        List < ItemStack > displayRecipes = new ArrayList < > (recipes.size() * 4);
        displayRecipes.add(new CustomItemStack(Material.STONE, "&7任意石头变种"));
        displayRecipes.add(new CustomItemStack(Material.PAPER, "&7输出的元素取决于你输入的石头类型", "&7石头类型是随机决定的"));
        displayRecipes.add(new CustomItemStack(Material.YELLOW_STAINED_GLASS_PANE, "&e额外的结果"));
        displayRecipes.add(new CustomItemStack(SlimefunItems.STONE_CHUNK, 4));
        displayRecipes.add(new CustomItemStack(Material.GREEN_STAINED_GLASS_PANE, "&a可能的结果"));
        displayRecipes.add(Analisis.HEMATITE);
        displayRecipes.add(new CustomItemStack(Material.GREEN_STAINED_GLASS_PANE, "&a可能的结果"));
        displayRecipes.add(Analisis.MAGNETITE); displayRecipes.add(new CustomItemStack(Material.GREEN_STAINED_GLASS_PANE, "&a可能的结果")); displayRecipes.add(Analisis.MAGNESIOFERRITE); displayRecipes.add(new CustomItemStack(Material.GREEN_STAINED_GLASS_PANE, "&a可能的结果")); displayRecipes.add(Analisis.GOETHITE); displayRecipes.add(new CustomItemStack(Material.GREEN_STAINED_GLASS_PANE, "&a可能的结果")); displayRecipes.add(Analisis.HYDROGOETHITE); displayRecipes.add(new CustomItemStack(Material.GREEN_STAINED_GLASS_PANE, "&a可能的结果")); displayRecipes.add(Analisis.LIMONITE); displayRecipes.add(new CustomItemStack(Material.GREEN_STAINED_GLASS_PANE, "&a可能的结果")); displayRecipes.add(Analisis.SIDERITE); displayRecipes.add(new CustomItemStack(Material.GREEN_STAINED_GLASS_PANE, "&a可能的结果")); displayRecipes.add(Analisis.PYRITE); displayRecipes.add(new CustomItemStack(Material.GREEN_STAINED_GLASS_PANE, "&a可能的结果")); displayRecipes.add(Analisis.PYRROTITE); displayRecipes.add(new CustomItemStack(Material.GREEN_STAINED_GLASS_PANE, "&a可能的结果")); displayRecipes.add(Analisis.ILMENITE); displayRecipes.add(new CustomItemStack(Material.GREEN_STAINED_GLASS_PANE, "&a可能的结果")); displayRecipes.add(Analisis.FOOL_GOLD); displayRecipes.add(new CustomItemStack(Material.GREEN_STAINED_GLASS_PANE, "&a可能的结果")); displayRecipes.add(Analisis.CALAVERITE); displayRecipes.add(new CustomItemStack(Material.GREEN_STAINED_GLASS_PANE, "&a可能的结果")); displayRecipes.add(Analisis.BISMITE); displayRecipes.add(new CustomItemStack(Material.GREEN_STAINED_GLASS_PANE, "&a可能的结果")); displayRecipes.add(Analisis.BISMUTHINITE);

            return displayRecipes;
        }
        @Override
        public void tick(Block b) {
            BlockMenu inv = BlockStorage.getInventory(b);
            CraftingOperation currentOperation = processor.getOperation(b);

            if (currentOperation != null) {
                if (takeCharge(b.getLocation())) {

                    if (!currentOperation.isFinished()) {
                        processor.updateProgressBar(inv, 21, currentOperation);
                        currentOperation.addProgress(1);
                    } else {
                        inv.replaceExistingItem(21, new CustomItemStack(Material.BLACK_STAINED_GLASS_PANE, " "));

                        for (ItemStack output: currentOperation.getResults()) {
                            if (inv.hasViewer()) {
                                switch (ThreadLocalRandom.current().nextInt(12)) {
                                    //iron ores
                                    case 0:
                                        inv.pushItem(output.clone(), getOutputSlots());
                                        inv.pushItem(new CustomItemStack(Elements.IRON.clone(), 2), getOutputSlots());
                                        inv.pushItem(new CustomItemStack(Elements.OXYGEN.clone(), 3), getOutputSlots());
                                    case 1:
                                        inv.pushItem(output.clone(), getOutputSlots());
                                        inv.pushItem(new CustomItemStack(Elements.IRON.clone(), 3), getOutputSlots());
                                        inv.pushItem(new CustomItemStack(Elements.OXYGEN.clone(), 4), getOutputSlots());
                                    case 2:
                                        inv.pushItem(output.clone(), getOutputSlots());
                                        inv.pushItem(new CustomItemStack(Elements.MAGNESIUM.clone(), 1), getOutputSlots());
                                        inv.pushItem(new CustomItemStack(Elements.OXYGEN.clone(), 1), getOutputSlots());
                                        inv.pushItem(new CustomItemStack(Elements.IRON.clone(), 2), getOutputSlots());
                                        inv.pushItem(new CustomItemStack(Elements.OXYGEN.clone(), 3), getOutputSlots());
                                    case 3:
                                        inv.pushItem(output.clone(), getOutputSlots());
                                        inv.pushItem(new CustomItemStack(Elements.IRON.clone(), 2), getOutputSlots());
                                        inv.pushItem(new CustomItemStack(Elements.OXYGEN.clone(), 3), getOutputSlots());
                                        inv.pushItem(new CustomItemStack(Elements.HYDROGEN.clone(), 2), getOutputSlots());
                                        inv.pushItem(new CustomItemStack(Elements.OXYGEN.clone(), 1), getOutputSlots());
                                    case 4:
                                        inv.pushItem(output.clone(), getOutputSlots());
                                        inv.pushItem(new CustomItemStack(Elements.IRON.clone(), 2), getOutputSlots());
                                        inv.pushItem(new CustomItemStack(Elements.OXYGEN.clone(), 3), getOutputSlots());
                                        inv.pushItem(new CustomItemStack(Elements.HYDROGEN.clone(), 8), getOutputSlots());
                                        inv.pushItem(new CustomItemStack(Elements.OXYGEN.clone(), 4), getOutputSlots());
                                    case 5:
                                        inv.pushItem(output.clone(), getOutputSlots());
                                        inv.pushItem(new CustomItemStack(Elements.IRON.clone(), 2), getOutputSlots());
                                        inv.pushItem(new CustomItemStack(Elements.OXYGEN.clone(), 3), getOutputSlots());
                                        inv.pushItem(new CustomItemStack(Elements.HYDROGEN.clone(), 6), getOutputSlots());
                                        inv.pushItem(new CustomItemStack(Elements.OXYGEN.clone(), 3), getOutputSlots());
                                    case 6:
                                        inv.pushItem(output.clone(), getOutputSlots());
                                        inv.pushItem(new CustomItemStack(Elements.IRON.clone(), 1), getOutputSlots());
                                        inv.pushItem(new CustomItemStack(Elements.CARBON.clone(), 1), getOutputSlots());
                                        inv.pushItem(new CustomItemStack(Elements.OXYGEN.clone(), 3), getOutputSlots());
                                    case 7:
                                        inv.pushItem(output.clone(), getOutputSlots());
                                        inv.pushItem(new CustomItemStack(Elements.IRON.clone(), 1), getOutputSlots());
                                        inv.pushItem(new CustomItemStack(Elements.SILICON.clone(), 2), getOutputSlots());
                                    case 8:
                                        inv.pushItem(output.clone(), getOutputSlots());
                                        inv.pushItem(new CustomItemStack(Elements.IRON.clone(), 1), getOutputSlots());
                                        inv.pushItem(new CustomItemStack(Elements.SILICON.clone(), 1), getOutputSlots());
                                    case 9:
                                        inv.pushItem(output.clone(), getOutputSlots());
                                        inv.pushItem(new CustomItemStack(Elements.IRON.clone(), 1), getOutputSlots());
                                        inv.pushItem(new CustomItemStack(Elements.OXYGEN.clone(), 3), getOutputSlots());
                                        //bismuths
                                    case 10:
                                        inv.pushItem(output.clone(), getOutputSlots());
                                        inv.pushItem(new CustomItemStack(Elements.BISMUTH.clone(), 2), getOutputSlots());
                                        inv.pushItem(new CustomItemStack(Elements.OXYGEN.clone(), 3), getOutputSlots());
                                    case 11:
                                        inv.pushItem(output.clone(), getOutputSlots());
                                        inv.pushItem(new CustomItemStack(Elements.BISMUTH.clone(), 2), getOutputSlots());
                                        inv.pushItem(new CustomItemStack(Elements.SILICON.clone(), 3), getOutputSlots());
                                        //gold
                                    case 12:
                                        inv.pushItem(output.clone(), getOutputSlots());
                                        inv.pushItem(new CustomItemStack(Elements.GOLD.clone(), 1), getOutputSlots());
                                        inv.pushItem(new CustomItemStack(Elements.TELLURIUM.clone(), 2), getOutputSlots());
                                    case 13:
                                        inv.pushItem(output.clone(), getOutputSlots());
                                        inv.pushItem(new CustomItemStack(Elements.IRON.clone(), 2), getOutputSlots());
                                        inv.pushItem(new CustomItemStack(Elements.SILICON.clone(), 3), getOutputSlots());
                                }
                            } else {
                                inv.pushItem(output.clone(), getOutputSlots());
                            }
                        }

                        processor.endOperation(b);
                    }
                }
            } else {
                MachineRecipe next = findNextRecipe(inv);

                if (next != null) {
                    getMachineProcessor().startOperation(b, new CraftingOperation(next));
                }
            }
        }

        @Override
        protected void registerDefaultRecipes() {
            registerRecipe(4, new ItemStack[] {
                    new ItemStack(Material.COBBLESTONE)
                },
                new ItemStack[] {
                    new CustomItemStack(SlimefunItems.STONE_CHUNK, 4)
                });
            registerRecipe(4, new ItemStack[] {
                    new ItemStack(Material.STONE)
                },
                new ItemStack[] {
                    new CustomItemStack(SlimefunItems.STONE_CHUNK, 4)
                });
            registerRecipe(4, new ItemStack[] {
                    new ItemStack(Material.GRANITE)
                },
                new ItemStack[] {
                    new CustomItemStack(SlimefunItems.STONE_CHUNK, 4)
                });
            registerRecipe(4, new ItemStack[] {
                    new ItemStack(Material.DIORITE)
                },
                new ItemStack[] {
                    new CustomItemStack(SlimefunItems.STONE_CHUNK, 4)
                });
            registerRecipe(4, new ItemStack[] {
                    new ItemStack(Material.ANDESITE)
                },
                new ItemStack[] {
                    new CustomItemStack(SlimefunItems.STONE_CHUNK, 4)
                });
            registerRecipe(4, new ItemStack[] {
                    new ItemStack(Material.COBBLED_DEEPSLATE)
                },
                new ItemStack[] {
                    new CustomItemStack(SlimefunItems.STONE_CHUNK, 4)
                });
            registerRecipe(4, new ItemStack[] {
                    new ItemStack(Material.DEEPSLATE)
                },
                new ItemStack[] {
                    new CustomItemStack(SlimefunItems.STONE_CHUNK, 4)
                });
            registerRecipe(4, new ItemStack[] {
                    new ItemStack(Material.TUFF)
                },
                new ItemStack[] {
                    new CustomItemStack(SlimefunItems.STONE_CHUNK, 4)
                });
            registerRecipe(4, new ItemStack[] {
                    new ItemStack(Material.CALCITE)
                },
                new ItemStack[] {
                    new CustomItemStack(SlimefunItems.STONE_CHUNK, 4)
                });
            registerRecipe(4, new ItemStack[] {
                    new ItemStack(Material.DRIPSTONE_BLOCK)
                },
                new ItemStack[] {
                    new CustomItemStack(SlimefunItems.STONE_CHUNK, 4)
                });
            registerRecipe(4, new ItemStack[] {
                    new ItemStack(Material.POINTED_DRIPSTONE)
                },
                new ItemStack[] {
                    new CustomItemStack(SlimefunItems.STONE_CHUNK, 4)
                });
            registerRecipe(4, new ItemStack[] {
                    new ItemStack(Material.BASALT)
                },
                new ItemStack[] {
                    new CustomItemStack(SlimefunItems.STONE_CHUNK, 4)
                });
        }

        @Nonnull
        @Override
        public String getMachineIdentifier() {
            return "ROCK_ANALYZER";
        }

        @Override
        public ItemStack getProgressBar() {
            return new ItemStack(Material.SPYGLASS);
        }
    }