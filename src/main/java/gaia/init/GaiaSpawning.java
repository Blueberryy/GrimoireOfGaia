package gaia.init;

import static gaia.GaiaConfig.GENERAL;
import static gaia.GaiaConfig.SPAWN;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.ImmutableSet;

import gaia.Gaia;
import gaia.GaiaConfig;
import gaia.GaiaReference;
import gaia.entity.EntityMobHostileBase;
import gaia.entity.EntityMobPassive;
import gaia.entity.monster.EntityGaiaAnt;
import gaia.entity.monster.EntityGaiaAntRanger;
import gaia.entity.monster.EntityGaiaAnubis;
import gaia.entity.monster.EntityGaiaArachne;
import gaia.entity.monster.EntityGaiaBanshee;
import gaia.entity.monster.EntityGaiaBaphomet;
import gaia.entity.monster.EntityGaiaBee;
import gaia.entity.monster.EntityGaiaBoneKnight;
import gaia.entity.monster.EntityGaiaCecaelia;
import gaia.entity.monster.EntityGaiaCentaur;
import gaia.entity.monster.EntityGaiaCobbleGolem;
import gaia.entity.monster.EntityGaiaCobblestoneGolem;
import gaia.entity.monster.EntityGaiaCreep;
import gaia.entity.monster.EntityGaiaCyclops;
import gaia.entity.monster.EntityGaiaDeathword;
import gaia.entity.monster.EntityGaiaDhampir;
import gaia.entity.monster.EntityGaiaDryad;
import gaia.entity.monster.EntityGaiaDullahan;
import gaia.entity.monster.EntityGaiaDwarf;
import gaia.entity.monster.EntityGaiaEnderDragonGirl;
import gaia.entity.monster.EntityGaiaEnderEye;
import gaia.entity.monster.EntityGaiaFleshLich;
import gaia.entity.monster.EntityGaiaGryphon;
import gaia.entity.monster.EntityGaiaHarpy;
import gaia.entity.monster.EntityGaiaHunter;
import gaia.entity.monster.EntityGaiaKobold;
import gaia.entity.monster.EntityGaiaMatango;
import gaia.entity.monster.EntityGaiaMermaid;
import gaia.entity.monster.EntityGaiaMinotaur;
import gaia.entity.monster.EntityGaiaMinotaurus;
import gaia.entity.monster.EntityGaiaMummy;
import gaia.entity.monster.EntityGaiaNaga;
import gaia.entity.monster.EntityGaiaNineTails;
import gaia.entity.monster.EntityGaiaOni;
import gaia.entity.monster.EntityGaiaOrc;
import gaia.entity.monster.EntityGaiaSatyress;
import gaia.entity.monster.EntityGaiaSelkie;
import gaia.entity.monster.EntityGaiaShaman;
import gaia.entity.monster.EntityGaiaSharko;
import gaia.entity.monster.EntityGaiaSiren;
import gaia.entity.monster.EntityGaiaSludgeGirl;
import gaia.entity.monster.EntityGaiaSphinx;
import gaia.entity.monster.EntityGaiaSpriggan;
import gaia.entity.monster.EntityGaiaSuccubus;
import gaia.entity.monster.EntityGaiaToad;
import gaia.entity.monster.EntityGaiaValkyrie;
import gaia.entity.monster.EntityGaiaVampire;
import gaia.entity.monster.EntityGaiaWerecat;
import gaia.entity.monster.EntityGaiaWitch;
import gaia.entity.monster.EntityGaiaWitherCow;
import gaia.entity.monster.EntityGaiaYeti;
import gaia.entity.monster.EntityGaiaYukiOnna;
import gaia.entity.passive.EntityGaiaPropChestMimic;
import gaia.entity.passive.EntityGaiaPropFlowerCyan;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Streamlined Spawning Registry, Tried to keep structure as similar, but cleaned up methods and repetitive code to save time and fingers.
 */
public class GaiaSpawning {
	private GaiaSpawning() {}

	/**
	 * Bridge Method for simpler spawning registry
	 */
	public static void add(int weight, Class<? extends EntityLiving> entityclassIn, int groupCountMin, int groupCountMax, Biome biome) {
		if (weight > 0) {
			biome.getSpawnableList(EnumCreatureType.MONSTER).add(new SpawnListEntry(entityclassIn, weight, groupCountMin, groupCountMax));
		}
	}

	/**
	 * Underground Creature Roster
	 */
	private static void underground(Biome biome) {
		add(GENERAL.spawnCreep, EntityGaiaCreep.class, 2, 4, biome);
		add(GENERAL.spawnEnderEye, EntityGaiaEnderEye.class, 2, 4, biome);
		add(GENERAL.spawnArachne, EntityGaiaArachne.class, 1, 2, biome);
		add(GENERAL.spawnMimic, EntityGaiaPropChestMimic.class, 1, 2, biome);
		add(GENERAL.spawnDeathword, EntityGaiaDeathword.class, 1, 2, biome);
		add(GENERAL.spawnBoneKnight, EntityGaiaBoneKnight.class, 1, 2, biome);
		add(GENERAL.spawnFleshLich, EntityGaiaFleshLich.class, 1, 2, biome);
	}

	// Water based mobs
	private static void aquatic(Biome biome) {
		add(GENERAL.spawnCecaelia, EntityGaiaCecaelia.class, 4, 6, biome);
		add(GENERAL.spawnMermaid, EntityGaiaMermaid.class, 2, 4, biome);
		add(GENERAL.spawnSharko, EntityGaiaSharko.class, 2, 4, biome);
	}

	/**
	 * Register Mobs based on Biome sub Types
	 */
	public static void register() {
		Map<Type, Set<Biome>> biomeMap = buildBiomeListByType();

		addForestSPAWN(biomeMap);
		addSandySPAWN(biomeMap);
		addPlainsSPAWN(biomeMap);
		addSwampSPAWN(biomeMap);
		addJungleSPAWN(biomeMap);
		addSnowySPAWN(biomeMap);
		addMountainSPAWN(biomeMap);
		addMesaSPAWN(biomeMap);
		addWaterSPAWN(biomeMap);
		addBeachSPAWN(biomeMap);
		addNetherSPAWN(biomeMap);
		addEndSPAWN(biomeMap);
	}

	private static void addEndSPAWN(Map<Type, Set<Biome>> biomeMap) {
		/* 
		 * SKY 
		 */
		for (Biome biome : biomeMap.get(Type.END)) {
			if (BiomeDictionary.hasType(biome, Type.COLD) && (BiomeDictionary.hasType(biome, Type.DRY))) {
				add(GENERAL.spawnEnderDragonGirl, EntityGaiaEnderDragonGirl.class, 1, 2, biome);
			}
		}
	}

	private static void addNetherSPAWN(Map<Type, Set<Biome>> biomeMap) {
		/* 
		 * NETHER 
		 */
		for (Biome biome : biomeMap.get(Type.NETHER)) {
			add(GENERAL.spawnSuccubus, EntityGaiaSuccubus.class, 2, 4, biome);
			add(GENERAL.spawnWitherCow, EntityGaiaWitherCow.class, 1, 2, biome);
			add(GENERAL.spawnBaphomet, EntityGaiaBaphomet.class, 1, 2, biome);
		}
	}

	private static void addBeachSPAWN(Map<Type, Set<Biome>> biomeMap) {
		/*
		 * BEACH,
		 * STONE_BEACH,
		 * COLD_BEACH
		 */
		for (Biome biome : biomeMap.get(Type.BEACH)) {
			if (!BiomeDictionary.hasType(biome, Type.MUSHROOM)) {
				aquatic(biome);
			}
		}
	}

	private static void addWaterSPAWN(Map<Type, Set<Biome>> biomeMap) {
		/*
		 * OCEAN,
		 * RIVER,
		 * FROZEN_OCEAN,
		 * FROZEN_RIVER,
		 * DEEP_OCEAN
		 */
		Set<Biome> water = new ImmutableSet.Builder<Biome>().addAll(biomeMap.get(Type.OCEAN)).addAll(biomeMap.get(Type.RIVER)).build();
		for (Biome biome : water) {
			aquatic(biome);
		}
	}

	private static void addMountainSPAWN(Map<Type, Set<Biome>> biomeMap) {
		/*
		 * EXTREME_HILLS,
		 * EXTREME_HILLS_EDGE,
		 * EXTREME_HILLS_WITH_TREES
		 */
		for (Biome biome : biomeMap.get(Type.MOUNTAIN)) {
			if (!BiomeDictionary.hasType(biome, Type.SNOWY) && 
					!BiomeDictionary.hasType(biome, Type.SANDY)) {
				add(GENERAL.spawnGryphon, EntityGaiaGryphon.class, 1, 2, biome);
				add(GENERAL.spawnDwarf, EntityGaiaDwarf.class, 4, 6, biome);

				if (!SPAWN.spawnLevel3) {
					add(GENERAL.spawnValkyrie, EntityGaiaValkyrie.class, 1, 2, biome);
				}

				add(GENERAL.spawnDullahan, EntityGaiaDullahan.class, 4, 6, biome);
				add(GENERAL.spawnBanshee, EntityGaiaBanshee.class, 2, 4, biome);

				underground(biome);
			}
		}
	}

	private static void addSnowySPAWN(Map<Type, Set<Biome>> biomeMap) {
		/*
		 * ICE_PLAINS,
		 * ICE_MOUNTAINS
		 */
		for (Biome biome : biomeMap.get(Type.SNOWY)) {
			if (!BiomeDictionary.hasType(biome, Type.CONIFEROUS) && 
					!BiomeDictionary.hasType(biome, Type.FOREST) &&
					!BiomeDictionary.hasType(biome, Type.OCEAN) && 
					!BiomeDictionary.hasType(biome, Type.RIVER) &&
					!BiomeDictionary.hasType(biome, Type.BEACH)) {
				add(GENERAL.spawnSelkie, EntityGaiaSelkie.class, 2, 4, biome);
				add(GENERAL.spawnKobold, EntityGaiaKobold.class, 4, 6, biome);
				add(GENERAL.spawnYeti, EntityGaiaYeti.class, 2, 4, biome);

				underground(biome);
			}
		}
	}

	private static void addJungleSPAWN(Map<Type, Set<Biome>> biomeMap) {
		/*
		 * JUNGLE,
		 * JUNGLE_HILLS,
		 * JUNGLE_EDGE
		 */
		for (Biome biome : biomeMap.get(Type.JUNGLE)) {
			add(GENERAL.spawnCobbleGolem, EntityGaiaCobbleGolem.class, 2, 4, biome);
			add(GENERAL.spawnHunter, EntityGaiaHunter.class, 2, 4, biome);
			add(GENERAL.spawnShaman, EntityGaiaShaman.class, 2, 4, biome);
			add(GENERAL.spawnCobblestoneGolem, EntityGaiaCobblestoneGolem.class, 2, 4, biome);

			underground(biome);
		}
	}

	private static void addSwampSPAWN(Map<Type, Set<Biome>> biomeMap) {
		/* SWAMPLAND */
		for (Biome biome : biomeMap.get(Type.SWAMP)) {
			add(GENERAL.spawnSiren, EntityGaiaSiren.class, 4, 6, biome);
			add(GENERAL.spawnSludgeGirl, EntityGaiaSludgeGirl.class, 2, 4, biome);
			add(GENERAL.spawnNaga, EntityGaiaNaga.class, 1, 2, biome);

			underground(biome);
		}
	}

	private static void addPlainsSPAWN(Map<Type, Set<Biome>> biomeMap) {
		/*
		 * PLAINS,
		 * SAVANNA,
		 * SAVANNA_PLATEAU
		 */
		for (Biome biome : biomeMap.get(Type.PLAINS)) {
			add(GENERAL.spawnSatyress, EntityGaiaSatyress.class, 2, 4, biome);
			add(GENERAL.spawnCentaur, EntityGaiaCentaur.class, 4, 6, biome);
			add(GENERAL.spawnHarpy, EntityGaiaHarpy.class, 2, 4, biome);
			add(GENERAL.spawnMinotaurus, EntityGaiaMinotaurus.class, 2, 4, biome);

			if (!SPAWN.spawnLevel3) {
				add(GENERAL.spawnMinotaur, EntityGaiaMinotaur.class, 1, 2, biome);
			}

			underground(biome);
		}
	}

	private static void addMesaSPAWN(Map<Type, Set<Biome>> biomeMap) {
		/*
		 * MESA,
		 * MESA_ROCK,
		 * MESA_CLEAR_ROCK
		 */
		for (Biome biome : biomeMap.get(Type.MESA)) {
			add(GENERAL.spawnOrc, EntityGaiaOrc.class, 2, 4, biome);

			underground(biome);
		}
	}

	private static void addSandySPAWN(Map<Type, Set<Biome>> biomeMap) {
		/* 
		 * DESERT,
		 * DESERT_HILLS
		 */
		for (Biome biome : biomeMap.get(Type.SANDY)) {
			if (!BiomeDictionary.hasType(biome, Type.MESA)) {
				add(GENERAL.spawnAnt, EntityGaiaAnt.class, 2, 4, biome);
				add(GENERAL.spawnAntRanger, EntityGaiaAntRanger.class, 2, 4, biome);
				add(GENERAL.spawnMummy, EntityGaiaMummy.class, 2, 4, biome);
				add(GENERAL.spawnAnubis, EntityGaiaAnubis.class, 2, 4, biome);

				if (!SPAWN.spawnLevel3) {
					add(GENERAL.spawnSphinx, EntityGaiaSphinx.class, 1, 2, biome);
				}

				underground(biome);
			}

			underground(biome);
		}
	}

	private static void addForestSPAWN(Map<Type, Set<Biome>> biomeMap) {
		for (Biome biome : biomeMap.get(Type.FOREST)) {
			/* 
			 * FOREST, 
			 * FOREST_HILLS, 
			 * BIRCH_FOREST, 
			 * BIRCH_FOREST_HILLS
			 */
			if (!BiomeDictionary.hasType(biome, Type.CONIFEROUS) && 
					!BiomeDictionary.hasType(biome, Type.SNOWY) &&
					!BiomeDictionary.hasType(biome, Type.MOUNTAIN) && 
					!BiomeDictionary.hasType(biome, Type.SPOOKY) &&
					!BiomeDictionary.hasType(biome, Type.MAGICAL)) {
				add(GENERAL.spawnDryad, EntityGaiaDryad.class, 4, 6, biome);
				add(GENERAL.spawnBee, EntityGaiaBee.class, 2, 4, biome);
				add(GENERAL.spawnMandragora, EntityGaiaPropFlowerCyan.class, 1, 2, biome);
				add(GENERAL.spawnWerecat, EntityGaiaWerecat.class, 4, 6, biome);
				add(GENERAL.spawnSpriggan, EntityGaiaSpriggan.class, 2, 4, biome);

				underground(biome);
			}

			/* 
			 * TAIGA
			 * REDWOOD_TAIGA,
			 * REDWOOD_TAIGA_HILLS
			 */
			if (BiomeDictionary.hasType(biome, Type.CONIFEROUS) && (!BiomeDictionary.hasType(biome, Type.SNOWY))) {
				add(GENERAL.spawnMandragora, EntityGaiaPropFlowerCyan.class, 1, 2, biome);
				add(GENERAL.spawnCyclops, EntityGaiaCyclops.class, 4, 6, biome);
				add(GENERAL.spawnYukiOnna, EntityGaiaYukiOnna.class, 2, 4, biome);
				add(GENERAL.spawnOni, EntityGaiaOni.class, 4, 6, biome);
				add(GENERAL.spawnNineTails, EntityGaiaNineTails.class, 2, 4, biome);

				underground(biome);
			}

			/* 
			 * COLD_TAIGA, 
			 * COLD_TAIGA_HILLS, 
			 * REDWOOD_TAIGA,
			 * REDWOOD_TAIGA_HILLS 
			 */
			if (BiomeDictionary.hasType(biome, Type.CONIFEROUS) && (BiomeDictionary.hasType(biome, Type.SNOWY))) {
				add(GENERAL.spawnDhampir, EntityGaiaDhampir.class, 2, 4, biome);

				if (!SPAWN.spawnLevel3) {
					add(GENERAL.spawnVampire, EntityGaiaVampire.class, 1, 2, biome);
				}

				underground(biome);
			}

			/*
			 * ROOFED_FOREST
			 */
			if (BiomeDictionary.hasType(biome, Type.SPOOKY)) {
				add(GENERAL.spawnMatango, EntityGaiaMatango.class, 2, 4, biome);
				add(GENERAL.spawnToad, EntityGaiaToad.class, 2, 4, biome);
				add(GENERAL.spawnWitch, EntityGaiaWitch.class, 2, 4, biome);

				underground(biome);
			}
		}
	}

	/**
	 * "Mutated" biomes don't have type dictionaries by default. This addition compensates for specific sub biomes having gaps in creature spawning.
	 * TODO Remove this as Mutated biomes have now been included in biome dictionary.
	 */
	public static void biomeTweaks() {
		Gaia.LOGGER.info("Sub Biome Tweaks Enabled");

		BiomeDictionary.addTypes(Biomes.MUTATED_ROOFED_FOREST, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.SPOOKY, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.FOREST);
		BiomeDictionary.addTypes(Biomes.MUTATED_EXTREME_HILLS, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.MOUNTAIN);
		BiomeDictionary.addTypes(Biomes.MUTATED_EXTREME_HILLS_WITH_TREES, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.MOUNTAIN);
	}

	private static Map<Type, Set<Biome>> buildBiomeListByType() {
		Map<Type, Set<Biome>> biomesAndTypes = new HashMap<>();

		for (Biome biome : Biome.REGISTRY) {
			Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(biome);
			for (BiomeDictionary.Type type : types) {
				if (!biomesAndTypes.containsKey(type)) {
					biomesAndTypes.put(type, new HashSet<>());
				}

				biomesAndTypes.get(type).add(biome);
			}
		}

		return biomesAndTypes;
	}
	
	@SuppressWarnings({"unused", "squid:S1118"}) //used in registration reflection
	@Mod.EventBusSubscriber(modid = GaiaReference.MOD_ID)
	public static class DimensionHandler {
		@SubscribeEvent
		public static void onSpawn(final LivingSpawnEvent.CheckSpawn event) {
			if (event.getEntity() instanceof EntityMobPassive || event.getEntity() instanceof EntityMobHostileBase) {
				if(GaiaConfig.DIMENSIONS.dimensionBlacklist.length > 0)
				{
					event.setResult(Event.Result.DEFAULT);
					for (int i : GaiaConfig.DIMENSIONS.dimensionBlacklist) {
						if (i == event.getWorld().provider.getDimension()) {
							event.setResult(Event.Result.DENY);
						}
					}
				}
			}
		}
	}
}
