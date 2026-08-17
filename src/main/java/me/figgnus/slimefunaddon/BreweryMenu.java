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
        ItemStack breweryGroupItem = new CustomItemStack(Material.POTION, "&eDestileria", "", "&aExplora el arte de elaborar bebidas...");
        ItemMeta meta = breweryGroupItem.getItemMeta();
        assert meta != null;
        meta.addItemFlags(ItemFlag.HIDE_ADDITIONAL_TOOLTIP);
        breweryGroupItem.setItemMeta(meta);

        // Give your Category a unique id.
        NamespacedKey breweryGroupId = new NamespacedKey(this, "brewery_category");
        // creates group
        ItemGroup breweryGroup = new ItemGroup(breweryGroupId, breweryGroupItem);

        //item stacks (needed for creating item)
        SlimefunItemStack cauldron_stack = new SlimefunItemStack("BREWERY", Material.CAULDRON, "&eElaboracion de bebidas");
        SlimefunItemStack skotska_whisky_stack = new SlimefunItemStack("SKOTSKA_WHISKY", Material.POTION, "&eWhisky escoces");
        configureMeta(skotska_whisky_stack, createNewColor(186,125,84));
        SlimefunItemStack irska_whisky_stack = new SlimefunItemStack("IRSKA_WHISKY", Material.POTION, "&eWhisky irlandes");
        configureMeta(irska_whisky_stack, createNewColor(186,125,84));
        SlimefunItemStack bourbon_stack = new SlimefunItemStack("BOURBON", Material.POTION, "&eBourbon");
        configureMeta(bourbon_stack, createNewColor(186,125,84));
        SlimefunItemStack psenicne_pivo_stack = new SlimefunItemStack("PSENICNE_PIVO", Material.POTION, "&eCerveza de trigo");
        configureMeta(psenicne_pivo_stack, createNewColor(255,184,77));
        SlimefunItemStack pivo_stack = new SlimefunItemStack("PIVO", Material.POTION, "&eCerveza");
        configureMeta(pivo_stack, createNewColor(255,211,51));
        SlimefunItemStack tmavy_lezak_stack = new SlimefunItemStack("TMAVY_LEZAK", Material.POTION, "&eCerveza negra");
        configureMeta(tmavy_lezak_stack, createNewColor(101,0,19));
        SlimefunItemStack cervene_vino_stack = new SlimefunItemStack("CERVENE_VINO", Material.POTION, "&eVino tinto");
        configureMeta(cervene_vino_stack, Color.RED);
        SlimefunItemStack bile_vino_stack = new SlimefunItemStack("BILE_VINO", Material.POTION, "&eVino blanco");
        configureMeta(bile_vino_stack, Color.YELLOW);
        SlimefunItemStack medovina_stack = new SlimefunItemStack("MEDOVINA", Material.POTION, "&eHidromiel");
        configureMeta(medovina_stack, Color.ORANGE);
        SlimefunItemStack jablecna_medovina_stack = new SlimefunItemStack("JABLECNA_MEDOVINA", Material.POTION, "&eHidromiel de manzana");
        configureMeta(jablecna_medovina_stack, Color.ORANGE);
        SlimefunItemStack jablecny_most_stack = new SlimefunItemStack("JABLECNY_MOST", Material.POTION, "&eSidra de manzana");
        configureMeta(jablecny_most_stack, createNewColor(248,104,32));
        SlimefunItemStack jablecny_liker_stack = new SlimefunItemStack("JABLECNY_LIKER", Material.POTION, "&eLicor de manzana");
        configureMeta(jablecny_liker_stack, Color.RED);
        SlimefunItemStack rum_stack = new SlimefunItemStack("RUM", Material.POTION, "&eRon");
        configureMeta(rum_stack, Color.MAROON);
        SlimefunItemStack vodka_stack = new SlimefunItemStack("VODKA", Material.POTION, "&eVodka");
        configureMeta(vodka_stack, Color.WHITE);
        SlimefunItemStack houbova_vodka_stack = new SlimefunItemStack("HOUBOVA_VODKA", Material.POTION, "&eVodka de hongos");
        configureMeta(houbova_vodka_stack, createNewColor(255,153,153));
        SlimefunItemStack gin_stack = new SlimefunItemStack("GIN", Material.POTION, "&eGinebra");
        configureMeta(gin_stack, createNewColor(153,221,255));
        SlimefunItemStack tequila_stack = new SlimefunItemStack("TEQUILA2", Material.POTION, "&eTequila");
        configureMeta(tequila_stack, createNewColor(245,240,126));
        SlimefunItemStack absinth_stack = new SlimefunItemStack("ABSINTH", Material.POTION, "&eAbsenta");
        configureMeta(absinth_stack, Color.GREEN);
        SlimefunItemStack zeleny_absinth_stack = new SlimefunItemStack("ZELENY_ABSINTH", Material.POTION, "&eAbsenta verde");
        configureMeta(zeleny_absinth_stack, Color.LIME);
        SlimefunItemStack bramborova_polevka_stack = new SlimefunItemStack("BRAMBOROVA_POLEVKA", Material.POTION, "&eSopa de papa");
        configureMeta(bramborova_polevka_stack, Color.ORANGE);
        SlimefunItemStack kava_stack = new SlimefunItemStack("KAVA", Material.POTION, "&eCafe");
        configureMeta(kava_stack, Color.BLACK);
        SlimefunItemStack vajecnak_stack = new SlimefunItemStack("VAJECNAK", Material.POTION, "&eLicor de huevo");
        configureMeta(vajecnak_stack, createNewColor(255,230,128));

        //recipe for items
        ItemStack[] item = {null, null, null, null, null, null, null, null, null};

        ItemStack[] cauldron_recipe = {null, null, null, null, createMultiblockRecipe(Material.CAULDRON, "Llenar con agua"), null, createMultiblockRecipe(Material.COBBLESTONE_STAIRS, "El fuego debe quedar rodeado por escaleras"), createMultiblockRecipe(Material.FLINT_AND_STEEL, "Requiere fuego u otra fuente de calor"), createMultiblockRecipe(Material.COBBLESTONE_STAIRS, "El fuego debe quedar rodeado por escaleras")};
        ItemStack[] skotska_whisky_recipe = {createRecipeItem("Trigo", 9, Material.WHEAT), createRecipeItem("Levadura", "606be2df2122344bda479feece365ee0e9d5da276afa0e8ce8d848f373dd131", "&eLevadura", 2), null, null, null, null, createBarrel("Barril de roble", 10), createClock(4), createBrewingStand(2)};
        ItemStack[] irska_whisky_recipe = {createRecipeItem("Trigo", 8, Material.WHEAT), createRecipeItem("Levadura", "606be2df2122344bda479feece365ee0e9d5da276afa0e8ce8d848f373dd131", "&eLevadura", 2), null, null, null, null, createBarrel("Barril de roble", 3), createClock(4), createBrewingStand(3)};
        ItemStack[] bourbon_recipe = {createRecipeItem("Trigo", 4, Material.WHEAT), createRecipeItem("Maiz", "9bd3802e5fac03afab742b0f3cca41bcd4723bee911d23be29cffd5b965f1", "&eMaiz", 5), createRecipeItem("Levadura", "606be2df2122344bda479feece365ee0e9d5da276afa0e8ce8d848f373dd131", "&eLevadura", 1), null, null, null, createBarrel("Barril de roble", 3), createClock(4), createBrewingStand(2)};
        ItemStack[] psenicne_pivo_recipe = {createRecipeItem("Trigo", 3, Material.WHEAT), createRecipeItem("Levadura", "606be2df2122344bda479feece365ee0e9d5da276afa0e8ce8d848f373dd131", "&eLevadura", 1), null, null, null, null, createBarrel("Barril de abedul", 2), createClock(8), null};
        ItemStack[] pivo_recipe = {createRecipeItem("Trigo", 6, Material.WHEAT), createRecipeItem("Levadura", "606be2df2122344bda479feece365ee0e9d5da276afa0e8ce8d848f373dd131", "&eLevadura", 2), null, null, null, null, createBarrel("Cualquier barril", 3), createClock(8), null};
        ItemStack[] tmavy_lezak_recipe = {createRecipeItem("Trigo", 12, Material.WHEAT), createRecipeItem("Levadura", "606be2df2122344bda479feece365ee0e9d5da276afa0e8ce8d848f373dd131", "&eLevadura", 1), null, null, null, null, createBarrel("Barril de roble oscuro", 8), createClock(8), null};
        ItemStack[] cervene_vino_recipe = {createRecipeItem("Bayas dulces", 9, Material.SWEET_BERRIES), null, null, null, null, null, createBarrel("Cualquier barril", 20), createClock(5), null};
        ItemStack[] bile_vino_recipe = {createRecipeItem("Bayas luminosas", 9, Material.GLOW_BERRIES), null, null, null, null, null, createBarrel("Cualquier barril", 20), createClock(5), null};
        ItemStack[] medovina_recipe = {createRecipeItem("Frasco de miel", 4, Material.HONEY_BOTTLE), createRecipeItem("Azucar", 2, Material.SUGAR), createRecipeItem("Levadura", "606be2df2122344bda479feece365ee0e9d5da276afa0e8ce8d848f373dd131", "&eLevadura", 2), null, null, null, createBarrel("Barril de roble", 4), createClock(3), null};
        ItemStack[] jablecna_medovina_recipe = {createRecipeItem("Frasco de miel", 6, Material.HONEY_BOTTLE), createRecipeItem("Manzana", 2, Material.APPLE), createRecipeItem("Levadura", "606be2df2122344bda479feece365ee0e9d5da276afa0e8ce8d848f373dd131", "&eLevadura", 1), null, null, null, createBarrel("Barril de roble", 4), createClock(4), null};
        ItemStack[] jablecny_most_recipe = {createRecipeItem("Manzana", 14, Material.APPLE), null, null, null, null, null, createBarrel("Cualquier barril", 3), createClock(7), null};
        ItemStack[] jablecny_liker_recipe = {createRecipeItem("Manzana", 12, Material.APPLE), createRecipeItem("Azucar", 3, Material.SUGAR), null, null, null, null, createBarrel("Barril de acacia", 6), createClock(16), createBrewingStand(3)};
        ItemStack[] rum_recipe = {createRecipeItem("Maiz", "9bd3802e5fac03afab742b0f3cca41bcd4723bee911d23be29cffd5b965f1", "&eMaiz", 18), null, null, null, null, null, createBarrel("Barril de roble", 14), createClock(6), createBrewingStand(2)};
        ItemStack[] vodka_recipe = {createRecipeItem("Papa", 16, Material.POTATO), null, null, null, null, null, null, createClock(15), createBrewingStand(3)};
        ItemStack[] houbova_vodka_recipe = {createRecipeItem("Papa", 14, Material.POTATO), createRecipeItem("Hongo rojo", 3, Material.RED_MUSHROOM), createRecipeItem("Hongo marron", 3, Material.BROWN_MUSHROOM), null, null, null, null, createClock(18), createBrewingStand(5)};
        ItemStack[] gin_recipe = {createRecipeItem("Trigo", 9, Material.WHEAT), createRecipeItem("Orquidea azul", 6, Material.BLUE_ORCHID), createRecipeItem("Manzana", 1, Material.APPLE), null, null, null, null, createClock(6), createBrewingStand(2)};
        ItemStack[] tequila_recipe = {createRecipeItem("Cactus", 8, Material.CACTUS), null, null, null, null, null, createBarrel("Barril de abedul", 12), createClock(15), createBrewingStand(2)};
        ItemStack[] absinth_recipe = {createRecipeItem("Hierba", 15, Material.SHORT_GRASS), null, null, null, null, null, null, createClock(3), createBrewingStand(6)};
        ItemStack[] zeleny_absinth_recipe = {createRecipeItem("Hierba", 17, Material.SHORT_GRASS), createRecipeItem("Papa venenosa", 2, Material.POISONOUS_POTATO), null, null, null, null, null, createClock(5), createBrewingStand(6)};
        ItemStack[] bramborova_polevka_recipe = {createRecipeItem("Papa", 5, Material.POTATO), createRecipeItem("Hierba", 3, Material.SHORT_GRASS), null, null, null, null, null, createClock(3), null};
        ItemStack[] kava_recipe = {createRecipeItem("Granos de cacao", 12, Material.COCOA_BEANS), createRecipeItem("Cubo de leche", 2, Material.MILK_BUCKET), null, null, null, null, null, createClock(2), null};
        ItemStack[] vajecnak_recipe = {createRecipeItem("Huevo", 5, Material.EGG), createRecipeItem("Azucar", 2, Material.SUGAR), createRecipeItem("Cubo de leche", 1, Material.MILK_BUCKET), null, null, null, createBarrel("Cualquier barril", 3), createClock(2), null};
    
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
        lore.add(i + " minutos");
        ItemStack clock = new CustomItemStack(Material.CLOCK, "&aTiempo de coccion");
        ItemMeta meta = clock.getItemMeta();
        assert meta != null;
        meta.setLore(lore);
        clock.setItemMeta(meta);
        return clock;
    }

    private ItemStack createBrewingStand(int i) {
        List<String> lore = new ArrayList<>();
        lore.add(i + " destilaciones");
        ItemStack brewingStand = new CustomItemStack(Material.BREWING_STAND, "&aNumero de destilaciones");
        ItemMeta meta = brewingStand.getItemMeta();
        assert meta != null;
        meta.setLore(lore);
        brewingStand.setItemMeta(meta);
        return brewingStand;
    }

    private ItemStack createBarrel(String s, int i) {
        List<String> lore = new ArrayList<>();
        lore.add("Barril: " + s);
        lore.add("Tiempo: " + i + " anos");
        ItemStack barrel = new CustomItemStack(Material.BARREL, "&aTipo de barril");
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
    //        swMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    //        skotska_whisky_stack.setItemMeta(swMeta);

    // corn "9bd3802e5fac03afab742b0f3cca41bcd4723bee911d23be29cffd5b965f1"

}
