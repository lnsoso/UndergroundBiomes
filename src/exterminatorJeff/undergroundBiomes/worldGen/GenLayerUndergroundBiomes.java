package exterminatorJeff.undergroundBiomes.worldGen;

import net.minecraft.world.WorldType;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerUndergroundBiomes extends GenLayerUnderground
{
    /** this sets all the biomes that are allowed to appear in the overworld */
    private BiomeGenUndergroundBase[] allowedBiomes;

    public GenLayerUndergroundBiomes(long par1, GenLayerUnderground par3GenLayer, WorldType par4WorldType)
    {
        super(par1);
        this.allowedBiomes = new BiomeGenUndergroundBase[] {BiomeGenUndergroundBase.igneous1, BiomeGenUndergroundBase.igneous2, 
        		BiomeGenUndergroundBase.igneous3, BiomeGenUndergroundBase.igneous4,
        		BiomeGenUndergroundBase.igneous5, BiomeGenUndergroundBase.igneous6, BiomeGenUndergroundBase.igneous7, 
        		BiomeGenUndergroundBase.igneous8, BiomeGenUndergroundBase.igneous9, BiomeGenUndergroundBase.igneous10, 
        		BiomeGenUndergroundBase.igneous11, BiomeGenUndergroundBase.igneous12, BiomeGenUndergroundBase.igneous13, 
        		BiomeGenUndergroundBase.igneous14, BiomeGenUndergroundBase.igneous15, BiomeGenUndergroundBase.igneous16,
        		BiomeGenUndergroundBase.metamorphic1, BiomeGenUndergroundBase.metamorphic2, BiomeGenUndergroundBase.metamorphic3, 
        		BiomeGenUndergroundBase.metamorphic4, BiomeGenUndergroundBase.metamorphic5, BiomeGenUndergroundBase.metamorphic6,
        		BiomeGenUndergroundBase.metamorphic7, BiomeGenUndergroundBase.metamorphic8, BiomeGenUndergroundBase.metamorphic9, 
        		BiomeGenUndergroundBase.metamorphic10, BiomeGenUndergroundBase.metamorphic11, BiomeGenUndergroundBase.metamorphic12, 
        		BiomeGenUndergroundBase.metamorphic13, BiomeGenUndergroundBase.metamorphic14, BiomeGenUndergroundBase.metamorphic15, 
        		BiomeGenUndergroundBase.metamorphic16, BiomeGenUndergroundBase.vanillaStone1, BiomeGenUndergroundBase.vanillaStone2,
        		BiomeGenUndergroundBase.vanillaStone3, BiomeGenUndergroundBase.vanillaStone4
        		};
        this.parent = par3GenLayer;

    }

    /**
     * Returns a list of integer values generated by this layer. These may be interpreted as temperatures, rainfall
     * amounts, or biomeList[] indices based on the particular GenLayer subclass.
     */
    public int[] getInts(int par1, int par2, int par3, int par4)
    {
        int[] var5 = this.parent.getInts(par1, par2, par3, par4);
        int[] var6 = IntCache.getIntCache(par3 * par4);

        for (int var7 = 0; var7 < par4; ++var7)
        {
            for (int var8 = 0; var8 < par3; ++var8)
            {
                this.initChunkSeed((long)(var8 + par1), (long)(var7 + par2));
                int var9 = var5[var8 + var7 * par3];

                if (var9 == 0)
                {
                    var6[var8 + var7 * par3] = 0;
                }
                else if (var9 == BiomeGenUndergroundBase.igneous1.biomeID)
                {
                    var6[var8 + var7 * par3] = var9;
                }
                else if (var9 == 1)
                {
                    var6[var8 + var7 * par3] = this.allowedBiomes[this.nextInt(this.allowedBiomes.length)].biomeID;
                }
                else
                {
                    int var10 = this.allowedBiomes[this.nextInt(this.allowedBiomes.length)].biomeID;

                    if (var10 == BiomeGenUndergroundBase.igneous1.biomeID)
                    {
                        var6[var8 + var7 * par3] = var10;
                    }
                    else
                    {
                        var6[var8 + var7 * par3] = this.allowedBiomes[this.nextInt(this.allowedBiomes.length)].biomeID;
                    }
                }
            }
        }

        return var6;
    }
}
