//package cn.rmc.ultimategenerators.object.ender_crystal_generator;
//
//import cn.rmc.ultimategenerators.UltimateGenerators;
//import cn.rmc.ultimategenerators.Utils;
//import cn.rmc.ultimategenerators.lists.UGItems;
//import cn.rmc.ultimategenerators.object.abstracts.ModularGenerator;
//import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
//import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
//import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
//import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
//import io.github.thebusybiscuit.slimefun4.core.handlers.BlockBreakHandler;
//import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
//import io.github.thebusybiscuit.slimefun4.implementation.handlers.SimpleBlockBreakHandler;
//import io.github.thebusybiscuit.slimefun4.implementation.operations.FuelOperation;
//import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
//import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
//import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ClickAction;
//import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.MachineFuel;
//import me.mrCookieSlime.Slimefun.Objects.handlers.BlockTicker;
//import me.mrCookieSlime.Slimefun.api.BlockStorage;
//import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
//import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
//import org.bukkit.Bukkit;
//import org.bukkit.ChatColor;
//import org.bukkit.Location;
//import org.bukkit.Material;
//import org.bukkit.block.Block;
//import org.bukkit.entity.EnderCrystal;
//import org.bukkit.entity.EntityType;
//import org.bukkit.entity.Player;
//import org.bukkit.inventory.ItemStack;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class EnderCrystalGenerator extends ModularGenerator {
//    protected EnderCrystalGenerator(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
//        super(itemGroup, item, recipeType, recipe);
//
//        addItemHandler(new BlockTicker() {
//            @Override
//            public boolean isSynchronized() {
//                return true;
//            }
//
//            @Override
//            public void tick(Block block, SlimefunItem slimefunItem, Config config) {
//                Location l = block.getLocation();
//                Location genL = Utils.locModify(l.getBlock().getLocation(), 0.5F, -1.5F, 0.5F);
//                Location partL = Utils.locModify(genL, 0F, 2F, 0F);
//
//                Bukkit.getScheduler().scheduleSyncDelayedTask(UltimateGenerators.getImplement(), () -> {
//                    List<EnderCrystal> ecc = new ArrayList<>();
//
//                    l.getWorld().getNearbyEntities(l, 4D, 4D, 4D).stream().filter(ety -> (ety.getType().equals(EntityType.ENDER_CRYSTAL))).map(ety -> (EnderCrystal) ety).forEachOrdered(ec -> {
//                        try {
//                            if (!ec.isShowingBottom() && ec.getCustomName()
//                                    .equals(ChatColor.translateAlternateColorCodes('&', "&d&l强化末影水晶&r"))) {
//                                if (ec.getBeamTarget() == null) {
//                                    ec.setBeamTarget(genL);
//                                }
//                                if (ec.getBeamTarget().getBlock().getLocation()
//                                        .distance(genL.getBlock().getLocation()) == 0D) {
//                                    ecc.add(ec);
//                                }
//                            }
//                        } catch (Exception ex) {
//                            ec.setBeamTarget(null);
//                        }
//                    });
//                    setConnectedCrystalNum(l.getBlock(), ecc.size());
//                });
//
//                FuelOperation operation = processor.getOperation(l);
//                if (operation != null && !operation.isFinished()){
//
//                }
//
//
//            }
//        });
//    }
//
//    @Override
//    public int getGeneratedOutput(Location l, Config data) {
//        if (l.getBlock().isBlockPowered()) {
//            return 0;
//        }
//
//        if (!checkStructure(l.getBlock())) {
//            Utils.asyncDelay(() -> {
//                BlockStorage.getInventory(l).replaceExistingItem(8,
//                        new CustomItemStack(Material.MAP, "&f机器信息",
//                                "&3结构完整性: &4&l✘&r", "&3已连接水晶: &e" + getConnectedCrystalNum(l.getBlock()),
//                                "&3机器状态: &a正常"));
//            });
//            return 0;
//        }
//        return super.getGeneratedOutput(l, data);
//    }
//
//    @Override
//    public BlockBreakHandler onBlockBreak() {
//        return new SimpleBlockBreakHandler(){
//            @Override
//            public void onBlockBreak(Block b) {
//                BlockMenu inv = BlockStorage.getInventory(b);
//                if (inv != null) {
//                    for (int slot : getInputSlots()) {
//                        if (inv.getItemInSlot(slot) != null) {
//                            b.getWorld().dropItemNaturally(b.getLocation(), inv.getItemInSlot(slot));
//                            inv.replaceExistingItem(slot, null);
//                        }
//                    }
//                    for (int slot : getOutputSlots()) {
//                        if (inv.getItemInSlot(slot) != null) {
//                            b.getWorld().dropItemNaturally(b.getLocation(), inv.getItemInSlot(slot));
//                            inv.replaceExistingItem(slot, null);
//                        }
//                    }
//                }
//
//                b.getWorld().getNearbyEntities(b.getLocation(), 4D, 4D, 4D).stream().filter(ety -> (ety.getType().equals(EntityType.ENDER_CRYSTAL))).map(ety -> (EnderCrystal) ety).forEachOrdered(ec -> {
//                    try {
//                        if (!ec.isShowingBottom() && ec.getCustomName()
//                                .equals(ChatColor.translateAlternateColorCodes('&', "&d&l强化末影水晶&r"))) {
//                            if (ec.getBeamTarget().getBlock().getLocation().distance(Utils
//                                    .locModify(b.getLocation(), 0.5F, -1.5F, 0.5F).getBlock().getLocation()) == 0D) {
//                                ec.setBeamTarget(null);
//                            }
//                        }
//                    } catch (Exception ex) {
//                        ec.setBeamTarget(null);
//                    }
//                });
//            }
//        };
//
//    }
//
//    @Override
//    public void constructMenu(BlockMenuPreset preset) {
//        super.constructMenu(preset);
//        preset.addItem(22, new CustomItemStack(Material.GRAY_STAINED_GLASS_PANE, " "), (Player arg0, int arg1, ItemStack arg2, ClickAction arg3) -> false);
//        preset.addItem(8, new CustomItemStack(Material.MAP, "&f机器信息",
//                "&3结构完整性: &4&l✘&r", "&3已连接水晶: &e0", "&3机器状态: &e无"), (Player arg0, int arg1, ItemStack arg2, ClickAction arg3) -> false);
//
//    }
//
//
//    @Override
//    public boolean checkStructure(Block b) {
//        Location l = b.getLocation();
//
//        List<Location> ll = new ArrayList<>();
//
//        ll.add(Utils.locModify(l, -1, -1, -1));
//        ll.add(Utils.locModify(l, -1, -1, 0));
//        ll.add(Utils.locModify(l, -1, -1, 1));
//        ll.add(Utils.locModify(l, 0, -1, -1));
//        ll.add(Utils.locModify(l, 0, -1, 1));
//        ll.add(Utils.locModify(l, 1, -1, -1));
//        ll.add(Utils.locModify(l, 1, -1, 0));
//        ll.add(Utils.locModify(l, 1, -1, 1));
//
//        Location lll = Utils.locModify(l, 0, -1, 0);
//        if (BlockStorage.checkID(lll) == null || !BlockStorage.checkID(lll).equals("ENDER_CRYSTAL_GENERATOR_STABILIZER")
//                || lll.getBlock().isBlockPowered()) {
//            return false;
//        }
//
//        return ll.stream().noneMatch(lc -> (BlockStorage.checkID(lc) == null || !BlockStorage.checkID(lc).equals("ENDER_CRYSTAL_GENERATOR_BASE")));
//
//    }
//
//    @Override
//    public ItemStack getProgressBar() {
//        return new ItemStack(Material.END_CRYSTAL);
//    }
//
//    @Override
//    protected void registerDefaultFuelTypes() {
//        registerFuel(new MachineFuel(3600, UGItems.RUNE_COMPLEX_ENDER, SlimefunItems.STONE_CHUNK));
//    }
//
//    private static void setConnectedCrystalNum(Block b, int num) {
//        BlockStorage.addBlockInfo(b, "crystal-number", String.valueOf(num));
//    }
//
//    @SuppressWarnings("deprecation")
//    private static int getConnectedCrystalNum(Block b) {
//        if (!BlockStorage.hasBlockInfo(b)) {
//            return 0;
//        }
//        if (BlockStorage.getLocationInfo(b.getLocation(), "crystal-number") == null) {
//            return 0;
//        }
//        if (BlockStorage.getLocationInfo(b.getLocation(), "crystal-number").equals("")) {
//            return 0;
//        }
//        return Integer.parseInt(BlockStorage.getLocationInfo(b.getLocation(), "crystal-number"));
//    }
//}
