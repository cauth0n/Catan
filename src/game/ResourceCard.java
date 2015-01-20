package game;

public class ResourceCard {

	private ResourceType resourceType;

	public ResourceType getResourceType() {
		return resourceType;
	}

	public void setResourceType(ResourceType resourceType) {
		this.resourceType = resourceType;
	}

	public ResourceCard(ResourceType resourceType) {
		this.resourceType = resourceType;
	}

}
