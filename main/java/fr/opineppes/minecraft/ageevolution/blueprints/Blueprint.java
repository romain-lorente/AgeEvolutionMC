package fr.opineppes.minecraft.ageevolution.blueprints;

public interface Blueprint<I, O> {

	public I verifyStructure();
	
	public O build();
	
}
