package me.figgnus.slimefunaddon;


import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.drakescraft_labs.slimefun4.api.items.ItemGroup;
import com.github.drakescraft_labs.slimefun4.api.items.SlimefunItem;
import com.github.drakescraft_labs.slimefun4.api.items.SlimefunItemStack;
import com.github.drakescraft_labs.slimefun4.api.recipes.RecipeType;
import com.github.drakescraft_labs.slimefun4.api.SlimefunAddon;
import com.github.drakescraft_labs.slimefun4.libraries.dough.config.Config;
import com.github.drakescraft_labs.slimefun4.libraries.dough.items.CustomItemStack;

import java.util.ArrayList;
import java.util.List;


public class BreweryMenu extends JavaPlugin implements SlimefunAddon {

    @Override
    public void onEnable() {
        // Read something from your config.yml
        Config cfg = new Config(this);

        if (cfg.getBoolean("options.auto-update")) {
            // You could start an Auto-Updater for example
        }
        // item that represents group
        ItemStack breweryGroupItem = new CustomItemStack(Material.POTION, "&e酿酒", "", "&a探索酒精的美好世界...");
        ItemMeta meta = breweryGroupItem.getItemMeta();
        assert meta != null;
        meta.addItemFlags(ItemFlag.HIDE_ADDITIONAL_TOOLTIP);
        breweryGroupItem.setItemMeta(meta);

        // Give your Category a unique id.
        NamespacedKey breweryGroupId = new NamespacedKey(this, "brewery_category");
        // creates group
        ItemGroup breweryGroup = new ItemGroup(breweryGroupId, breweryGroupItem);

        //item stacks (needed for creating item)
        SlimefunItemStack cauldron_stack = new SlimefunItemStack("BREWERY", Material.CAULDRON, "&e酿酒");
        SlimefunItemStack skotska_whisky_stack = new SlimefunItemStack("SKOTSKA_WHISKY", Material.POTION, "&e苏格兰威士忌");
        configureMeta(skotska_whisky_stack, createNewColor(186,125,84));
        SlimefunItemStack irska_whisky_stack = new SlimefunItemStack("IRSKA_WHISKY", Material.POTION, "&e爱尔兰威士忌");
        configureMeta(irska_whisky_stack, createNewColor(186,125,84));
        SlimefunItemStack bourbon_stack = new SlimefunItemStack("BOURBON", Material.POTION, "&e波旁威士忌酒");
        configureMeta(bourbon_stack, createNewColor(186,125,84));
        SlimefunItemStack psenicne_pivo_stack = new SlimefunItemStack("PSENICNE_PIVO", Material.POTION, "&e麦酒");
        configureMeta(psenicne_pivo_stack, createNewColor(255,184,77));
        SlimefunItemStack pivo_stack = new SlimefunItemStack("PIVO", Material.POTION, "&e啤酒");
        configureMeta(pivo_stack, createNewColor(255,211,51));
        SlimefunItemStack tmavy_lezak_stack = new SlimefunItemStack("TMAVY_LEZAK", Material.POTION, "&e黑啤酒");
        configureMeta(tmavy_lezak_stack, createNewColor(101,0,19));
        SlimefunItemStack cervene_vino_stack = new SlimefunItemStack("CERVENE_VINO", Material.POTION, "&e红葡萄酒");
        configureMeta(cervene_vino_stack, Color.RED);
        SlimefunItemStack bile_vino_stack = new SlimefunItemStack("BILE_VINO", Material.POTION, "&e白葡萄酒");
        configureMeta(bile_vino_stack, Color.YELLOW);
        SlimefunItemStack medovina_stack = new SlimefunItemStack("MEDOVINA", Material.POTION, "&e蜂蜜酒");
        configureMeta(medovina_stack, Color.ORANGE);
        SlimefunItemStack jablecna_medovina_stack = new SlimefunItemStack("JABLECNA_MEDOVINA", Material.POTION, "&e苹果蜂蜜酒");
        configureMeta(jablecna_medovina_stack, Color.ORANGE);
        SlimefunItemStack jablecny_most_stack = new SlimefunItemStack("JABLECNY_MOST", Material.POTION, "&e苹果汁");
        configureMeta(jablecny_most_stack, createNewColor(248,104,32));
        SlimefunItemStack jablecny_liker_stack = new SlimefunItemStack("JABLECNY_LIKER", Material.POTION, "&e苹果利口酒");
        configureMeta(jablecny_liker_stack, Color.RED);
        SlimefunItemStack rum_stack = new SlimefunItemStack("RUM", Material.POTION, "&e朗姆酒");
        configureMeta(rum_stack, Color.MAROON);
        SlimefunItemStack vodka_stack = new SlimefunItemStack("VODKA", Material.POTION, "&e伏特加");
        configureMeta(vodka_stack, Color.WHITE);
        SlimefunItemStack houbova_vodka_stack = new SlimefunItemStack("HOUBOVA_VODKA", Material.POTION, "&e蘑菇伏特加");
        configureMeta(houbova_vodka_stack, createNewColor(255,153,153));
        SlimefunItemStack gin_stack = new SlimefunItemStack("GIN", Material.POTION, "&e杜松子酒");
        configureMeta(gin_stack, createNewColor(153,221,255));
        SlimefunItemStack tequila_stack = new SlimefunItemStack("TEQUILA2", Material.POTION, "&e龙舌兰酒");
        configureMeta(tequila_stack, createNewColor(245,240,126));
        SlimefunItemStack absinth_stack = new SlimefunItemStack("ABSINTH", Material.POTION, "&e苦艾酒");
        configureMeta(absinth_stack, Color.GREEN);
        SlimefunItemStack zeleny_absinth_stack = new SlimefunItemStack("ZELENY_ABSINTH", Material.POTION, "&e绿色苦艾酒");
        configureMeta(zeleny_absinth_stack, Color.LIME);
        SlimefunItemStack bramborova_polevka_stack = new SlimefunItemStack("BRAMBOROVA_POLEVKA", Material.POTION, "&e土豆汤");
        configureMeta(bramborova_polevka_stack, Color.ORANGE);
        SlimefunItemStack kava_stack = new SlimefunItemStack("KAVA", Material.POTION, "&e咖啡");
        configureMeta(kava_stack, Color.BLACK);
        SlimefunItemStack vajecnak_stack = new SlimefunItemStack("VAJECNAK", Material.POTION, "&e鸡蛋利口酒");
        configureMeta(vajecnak_stack, createNewColor(255,230,128));

        //recipe for items
        ItemStack[] item = {null, null, null, null, null, null, null, null, null};

        ItemStack[] cauldron_recipe = {null, null, null, null, createMultiblockRecipe(Material.CAULDRON, "将水灌满"), null, createMultiblockRecipe(Material.COBBLESTONE_STAIRS, "火必须被楼梯包围"), createMultiblockRecipe(Material.FLINT_AND_STEEL, "需要火和其他热源"), createMultiblockRecipe(Material.COBBLESTONE_STAIRS, "火必须被楼梯包围")};
        ItemStack[] skotska_whisky_recipe = {createRecipeItem("小麦", 9, Material.WHEAT), createRecipeItem("酵母", "606be2df2122344bda479feece365ee0e9d5da276afa0e8ce8d848f373dd131", "&e酵母", 2), null, null, null, null, createBarrel("橡木桶", 10), createClock(4), createBrewingStand(2)};
        ItemStack[] irska_whisky_recipe = {createRecipeItem("小麦", 8, Material.WHEAT), createRecipeItem("酵母", "606be2df2122344bda479feece365ee0e9d5da276afa0e8ce8d848f373dd131", "&e酵母", 2), null, null, null, null, createBarrel("橡木桶", 3), createClock(4), createBrewingStand(3)};
        ItemStack[] bourbon_recipe = {createRecipeItem("小麦", 4, Material.WHEAT), createRecipeItem("玉米", "9bd3802e5fac03afab742b0f3cca41bcd4723bee911d23be29cffd5b965f1", "&e玉米", 5), createRecipeItem("酵母", "606be2df2122344bda479feece365ee0e9d5da276afa0e8ce8d848f373dd131", "&e酵母", 1), null, null, null, createBarrel("橡木桶", 3), createClock(4), createBrewingStand(2)};
        ItemStack[] psenicne_pivo_recipe = {createRecipeItem("小麦", 3, Material.WHEAT), createRecipeItem("酵母", "606be2df2122344bda479feece365ee0e9d5da276afa0e8ce8d848f373dd131", "&e酵母", 1), null, null, null, null, createBarrel("白桦木桶", 2), createClock(8), null};
        ItemStack[] pivo_recipe = {createRecipeItem("小麦", 6, Material.WHEAT), createRecipeItem("酵母", "606be2df2122344bda479feece365ee0e9d5da276afa0e8ce8d848f373dd131", "&e酵母", 2), null, null, null, null, createBarrel("任意桶", 3), createClock(8), null};
        ItemStack[] tmavy_lezak_recipe = {createRecipeItem("小麦", 12, Material.WHEAT), createRecipeItem("酵母", "606be2df2122344bda479feece365ee0e9d5da276afa0e8ce8d848f373dd131", "&e酵母", 1), null, null, null, null, createBarrel("深色橡木桶", 8), createClock(8), null};
        ItemStack[] cervene_vino_recipe = {createRecipeItem("甜浆果", 9, Material.SWEET_BERRIES), null, null, null, null, null, createBarrel("任意桶", 20), createClock(5), null};
        ItemStack[] bile_vino_recipe = {createRecipeItem("发光浆果", 9, Material.GLOW_BERRIES), null, null, null, null, null, createBarrel("任意桶", 20), createClock(5), null};
        ItemStack[] medovina_recipe = {createRecipeItem("蜂蜜瓶", 4, Material.HONEY_BOTTLE), createRecipeItem("糖", 2, Material.SUGAR), createRecipeItem("酵母", "606be2df2122344bda479feece365ee0e9d5da276afa0e8ce8d848f373dd131", "&e酵母", 2), null, null, null, createBarrel("橡木桶", 4), createClock(3), null};
        ItemStack[] jablecna_medovina_recipe = {createRecipeItem("蜂蜜瓶", 6, Material.HONEY_BOTTLE), createRecipeItem("苹果", 2, Material.APPLE), createRecipeItem("酵母", "606be2df2122344bda479feece365ee0e9d5da276afa0e8ce8d848f373dd131", "&e酵母", 1), null, null, null, createBarrel("橡木桶", 4), createClock(4), null};
        ItemStack[] jablecny_most_recipe = {createRecipeItem("苹果", 14, Material.APPLE), null, null, null, null, null, createBarrel("任意桶", 3), createClock(7), null};
        ItemStack[] jablecny_liker_recipe = {createRecipeItem("苹果", 12, Material.APPLE), createRecipeItem("糖", 3, Material.SUGAR), null, null, null, null, createBarrel("金合欢木桶", 6), createClock(16), createBrewingStand(3)};
        ItemStack[] rum_recipe = {createRecipeItem("玉米", "9bd3802e5fac03afab742b0f3cca41bcd4723bee911d23be29cffd5b965f1", "&e玉米", 18), null, null, null, null, null, createBarrel("橡木桶", 14), createClock(6), createBrewingStand(2)};
        ItemStack[] vodka_recipe = {createRecipeItem("马铃薯", 16, Material.POTATO), null, null, null, null, null, null, createClock(15), createBrewingStand(3)};
        ItemStack[] houbova_vodka_recipe = {createRecipeItem("马铃薯", 14, Material.POTATO), createRecipeItem("红蘑菇", 3, Material.RED_MUSHROOM), createRecipeItem("棕色蘑菇", 3, Material.BROWN_MUSHROOM), null, null, null, null, createClock(18), createBrewingStand(5)};
        ItemStack[] gin_recipe = {createRecipeItem("小麦", 9, Material.WHEAT), createRecipeItem("兰花", 6, Material.BLUE_ORCHID), createRecipeItem("苹果", 1, Material.APPLE), null, null, null, null, createClock(6), createBrewingStand(2)};
        ItemStack[] tequila_recipe = {createRecipeItem("仙人掌", 8, Material.CACTUS), null, null, null, null, null, createBarrel("桦木桶", 12), createClock(15), createBrewingStand(2)};
        ItemStack[] absinth_recipe = {createRecipeItem("草", 15, Material.SHORT_GRASS), null, null, null, null, null, null, createClock(3), createBrewingStand(6)};
        ItemStack[] zeleny_absinth_recipe = {createRecipeItem("草", 17, Material.SHORT_GRASS), createRecipeItem("毒马铃薯", 2, Material.POISONOUS_POTATO), null, null, null, null, null, createClock(5), createBrewingStand(6)};
        ItemStack[] bramborova_polevka_recipe = {createRecipeItem("土豆", 5, Material.POTATO), createRecipeItem("草", 3, Material.SHORT_GRASS), null, null, null, null, null, createClock(3), null};
        ItemStack[] kava_recipe = {createRecipeItem("可可豆", 12, Material.COCOA_BEANS), createRecipeItem("牛奶桶", 2, Material.MILK_BUCKET), null, null, null, null, null, createClock(2), null};
        ItemStack[] vajecnak_recipe = {createRecipeItem("鸡蛋", 5, Material.EGG), createRecipeItem("糖", 2, Material.SUGAR), createRecipeItem("牛奶桶", 1, Material.MILK_BUCKET), null, null, null, createBarrel("任意桶", 3), createClock(2), null};
    
        //recipe type - adds icon of cauldron
        RecipeType MENU_BOTTLE = new RecipeType(breweryGroupId, breweryGroupItem);

        //creates items
        SlimefunItem cauldron = new SlimefunItem(breweryGroup, cauldron_stack, RecipeType.MULTIBLOCK, cauldron_recipe);
        SlimefunItem skotska_whisky = new SlimefunItem(breweryGroup, skotska_whisky_stack, MENU_BOTTLE, skotska_whisky_recipe);
        SlimefunItem irska_whisky = new SlimefunItem(breweryGroup, irska_whisky_stack, MENU_BOTTLE, irska_whisky_recipe);
        SlimefunItem bourbon = new SlimefunItem(breweryGroup, bourbon_stack, MENU_BOTTLE, bourbon_recipe);
        SlimefunItem psenicne_pivo = new SlimefunItem(breweryGroup, psenicne_pivo_stack, MENU_BOTTLE, psenicne_pivo_recipe);
        SlimefunItem pivo = new SlimefunItem(breweryGroup, pivo_stack, MENU_BOTTLE, pivo_recipe);
        SlimefunItem tmavy_lezak = new SlimefunItem(breweryGroup, tmavy_lezak_stack, MENU_BOTTLE, tmavy_lezak_recipe);
        SlimefunItem cervene_vino = new SlimefunItem(breweryGroup, cervene_vino_stack, MENU_BOTTLE, cervene_vino_recipe);
        SlimefunItem bile_vino = new SlimefunItem(breweryGroup, bile_vino_stack, MENU_BOTTLE, bile_vino_recipe);
        SlimefunItem medovina = new SlimefunItem(breweryGroup, medovina_stack, MENU_BOTTLE, medovina_recipe);
        SlimefunItem jablecna_medovina = new SlimefunItem(breweryGroup, jablecna_medovina_stack, MENU_BOTTLE, jablecna_medovina_recipe);
        SlimefunItem jablecny_most = new SlimefunItem(breweryGroup, jablecny_most_stack, MENU_BOTTLE, jablecny_most_recipe);
        SlimefunItem jablecny_liker = new SlimefunItem(breweryGroup, jablecny_liker_stack, MENU_BOTTLE, jablecny_liker_recipe);
        SlimefunItem rum = new SlimefunItem(breweryGroup, rum_stack, MENU_BOTTLE, rum_recipe);
        SlimefunItem vodka = new SlimefunItem(breweryGroup, vodka_stack, MENU_BOTTLE, vodka_recipe);
        SlimefunItem houbova_vodka = new SlimefunItem(breweryGroup, houbova_vodka_stack, MENU_BOTTLE, houbova_vodka_recipe);
        SlimefunItem gin = new SlimefunItem(breweryGroup, gin_stack, MENU_BOTTLE, gin_recipe);
        SlimefunItem tequila = new SlimefunItem(breweryGroup, tequila_stack, MENU_BOTTLE, tequila_recipe);
        SlimefunItem absinth = new SlimefunItem(breweryGroup, absinth_stack, MENU_BOTTLE, absinth_recipe);
        SlimefunItem zeleny_absinth = new SlimefunItem(breweryGroup, zeleny_absinth_stack, MENU_BOTTLE, zeleny_absinth_recipe);
        SlimefunItem bramborova_polevka = new SlimefunItem(breweryGroup, bramborova_polevka_stack, MENU_BOTTLE, bramborova_polevka_recipe);
        SlimefunItem kava = new SlimefunItem(breweryGroup, kava_stack, MENU_BOTTLE, kava_recipe);
        SlimefunItem vajecnak = new SlimefunItem(breweryGroup, vajecnak_stack, MENU_BOTTLE, vajecnak_recipe);

        //register items
        cauldron.register(this);
        skotska_whisky.register(this);
        irska_whisky.register(this);
        bourbon.register(this);
        psenicne_pivo.register(this);
        pivo.register(this);
        tmavy_lezak.register(this);
        cervene_vino.register(this);
        bile_vino.register(this);
        medovina.register(this);
        jablecna_medovina.register(this);
        jablecny_most.register(this);
        jablecny_liker.register(this);
        rum.register(this);
        vodka.register(this);
        houbova_vodka.register(this);
        gin.register(this);
        tequila.register(this);
        absinth.register(this);
        zeleny_absinth.register(this);
        bramborova_polevka.register(this);
        kava.register(this);
        vajecnak.register(this);

    }

    private Color createNewColor(int a, int b, int c){
        return Color.fromRGB(a, b, c);
    }

    private void configureMeta(SlimefunItemStack item, Color color) {
        PotionMeta meta = (PotionMeta) item.getItemMeta();
        assert meta != null;
        meta.setColor(color);
        meta.addItemFlags(ItemFlag.HIDE_ADDITIONAL_TOOLTIP);
        item.setItemMeta(meta);
    }

    private ItemStack createRecipeItem(String name, int amount, Material material){
        ItemStack item = new CustomItemStack(material, "&e" + name);
        item.setAmount(amount);
        return item;
    }
    private SlimefunItemStack createRecipeItem(String id, String name, String textrue, int amount){
        SlimefunItemStack item = new SlimefunItemStack(id, name, textrue);
        item.setAmount(amount);
        return item;
    }


    private ItemStack createClock(int i) {
        List<String > lore = new ArrayList<>();
        lore.add(i + " 分钟");
        ItemStack clock = new CustomItemStack(Material.CLOCK, "&a烹饪时间");
        ItemMeta meta = clock.getItemMeta();
        assert meta != null;
        meta.setLore(lore);
        clock.setItemMeta(meta);
        return clock;
    }

    private ItemStack createBrewingStand(int i) {
        List<String> lore = new ArrayList<>();
        lore.add(i + " 次数: ");
        ItemStack brewingStand = new CustomItemStack(Material.BREWING_STAND, "&a蒸馏次数");
        ItemMeta meta = brewingStand.getItemMeta();
        assert meta != null;
        meta.setLore(lore);
        brewingStand.setItemMeta(meta);
        return brewingStand;
    }

    private ItemStack createBarrel(String s, int i) {
        List<String> lore = new ArrayList<>();
        lore.add("酿酒桶: " + s);
        lore.add("时间: " + i + " 年");
        ItemStack barrel = new CustomItemStack(Material.BARREL, "&a桶类型");
        ItemMeta meta = barrel.getItemMeta();
        assert meta != null;
        meta.setLore(lore);
        barrel.setItemMeta(meta);
        return barrel;
    }
    private ItemStack createMultiblockRecipe(Material material, String lore_input){
        ItemStack item = new CustomItemStack(material);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        lore.add(lore_input);
        assert meta != null;
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    @Override
    public String getBugTrackerURL() {
        // You can return a link to your Bug Tracker instead of null here
        return null;
    }

    @Override
    public JavaPlugin getJavaPlugin() {
        /*
         * You will need to return a reference to your Plugin here.
         * If you are using your main class for this, simply return "this".
         */
        return this;
    }
    //        PotionMeta swMeta = (PotionMeta) skotska_whisky_stack.getItemMeta();
    //        swMeta.setColor(Color.LIME);
    //        swMeta.addItemFlags(ItemFlag.HIDE_ADDITIONAL_TOOLTIP);
    //        skotska_whisky_stack.setItemMeta(swMeta);

    // corn "9bd3802e5fac03afab742b0f3cca41bcd4723bee911d23be29cffd5b965f1"

}
