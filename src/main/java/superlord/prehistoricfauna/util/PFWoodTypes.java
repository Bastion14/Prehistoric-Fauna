package superlord.prehistoricfauna.util;

import java.util.Set;
import java.util.stream.Stream;

import it.unimi.dsi.fastutil.objects.ObjectArraySet;
import net.minecraft.block.WoodType;

public class PFWoodTypes extends WoodType
{
	private static final Set<WoodType> VALUES = new ObjectArraySet<>();
	public static final WoodType ARAUCARIA = PFWoodTypes.register(new PFWoodTypes("araucaria"));
	public static final WoodType METASEQUOIA = PFWoodTypes.register(new PFWoodTypes("metasequoia"));
	public static final WoodType HEIDIPHYLLUM = PFWoodTypes.register(new PFWoodTypes("heidiphyllum"));
	public static final WoodType LIRIODENDRITES = PFWoodTypes.register(new PFWoodTypes("liriodendrites"));
	public static final WoodType PROTOJUNIPEROXYLON = PFWoodTypes.register(new PFWoodTypes("protojuniper"));
	public static final WoodType PROTOPICEOXYLON = PFWoodTypes.register(new PFWoodTypes("protopiceoxylon"));
	public static final WoodType ZAMITES = PFWoodTypes.register(new PFWoodTypes("zamites"));
	
	private final String name;

	protected PFWoodTypes(String nameIn)
	{
		super(nameIn);
		this.name = nameIn;
	}

	private static WoodType register(WoodType woodTypeIn)
	{
		PFWoodTypes.VALUES.add(woodTypeIn);
		return woodTypeIn;
	}

	public static Stream<WoodType> getValues()
	{
		return PFWoodTypes.VALUES.stream();
	}

	@Override
	public String getName()
	{
		return this.name;
	}
}
