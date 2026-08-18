<p align="center"><img src="https://raw.githubusercontent.com/DrakesCraft-Labs/BreweryMenu/main/banner.svg" alt="BreweryMenu" width="100%"></p>

# BreweryMenu

> ### 🏰 ¡Únete a la Comunidad Oficial de DrakesCraft!
> 
> * 🎮 **IP del Servidor**: `play.drakescraft.net` *(Java 1.21.11 & Bedrock)*
> * 💬 **Discord Oficial**: [discord.gg/drakescraft](https://discord.gg/rR7FbfCt9Y)
> * 🌐 **Web & Guía**: [drakescraft.net](https://drakescraft.net) — 🛒 **Tienda**: [tienda.drakescraft.net](https://tienda.drakescraft.net)
> 
> *¡Juega con este addon y más de 80 expansiones optimizadas en vivo en nuestra network de supervivencia técnica!*

---

Menú de destilería para Slimefun, adaptado al ecosistema Slimefun de **DrakesCraft** (Paper/Purpur 1.21.11, Java 21).

## Qué añade

Un menú para las recetas de destilería, integrado con ExoticGarden.

## Ojo con esto

**Requiere ExoticGarden**, que está instalado en DrakesCraft. Sin él el plugin no arranca.

## Qué cambiamos

Este repositorio **no es un fork**: es el código original integrado en el ecosistema de
DrakesCraft (Paper/Purpur 1.21.11, Java 21). Los cambios comunes a todos nuestros ports son:

**Los paquetes de Slimefun.** El core de DrakesCraft está repaquetado, así que un addon de fuera
no encuentra nada hasta que se remapean sus imports.

**La telemetría, fuera.** bStats abría una conexión a bstats.org cada pocos minutos con datos del
servidor. Se quitaron las llamadas, los imports y la dependencia — no se sustituyó por un stub
inerte, que dejaría el código en pie aparentando que hay telemetría.

**Los autoactualizadores, desarmados.** Este jar está recompilado contra nuestro Slimefun; si se
bajara el de upstream encima, dejaría de cargar. Las actualizaciones se despliegan por SFTP.

**El rastreador de fallos apunta aquí**, no al repositorio original: un fallo de esta versión
casi nunca es un fallo de allí.
