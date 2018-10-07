package competitiveProgramming.stackoverflow;

public class DoubleQuoteString51872064 {
	public static void main(String[] args) {
		// Setting the Object
		Device device = new Device();
		device.setName("Test");
		device.setDeviceHardId("123");
		device.setDeviceType("A");
		Playlist play = new Playlist();
		play.setId("105");
		play.setName("Dummy");
		device.setPlaylist(play);

		StringBuffer stringBuffer = new StringBuffer("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		stringBuffer.append("<tv time=\"10\" name=\"" + device.getName() + "\" " + "id=\"" + device.getDeviceHardId() + "\" device=\"" + device.getDeviceType() + "\">");
		Playlist playlist1 = device.getPlaylist();
		if (playlist1 != null) {
			stringBuffer.append("<playlist name=\"" + playlist1.getName() + "\" id=\"" + playlist1.getId() + "\">");
			stringBuffer.append("</playlist>");
		}
		stringBuffer.append("</tv>");
		System.out.println(stringBuffer);

		StringBuffer str = new StringBuffer();
		str.append("<?xml version=&quot1.0&quot encoding=&quotUTF-8&quot?><tv time=&quot10&quot name=&quot"+ device.getName() + "&quot id=&quot" + device.getDeviceHardId() + "&quot device=&quot"+ device.getDeviceType() + "&quot>");
		Playlist playlist2 = device.getPlaylist();
		if (playlist2 != null) {
			str.append("<playlist name=&quot" + playlist2.getName() + "&quot id=&quot" + playlist2.getId()+"&quot></playlist></tv>");
		}
		System.out.println(str.toString().replace("&quot", "\""));
	}
}

class Device {
	private String name;
	private String deviceType;
	private String deviceHardId;
	private Playlist playlist;

	public Playlist getPlaylist() {
		return playlist;
	}

	public void setPlaylist(Playlist playlist) {
		this.playlist = playlist;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getDeviceHardId() {
		return deviceHardId;
	}

	public void setDeviceHardId(String deviceHardId) {
		this.deviceHardId = deviceHardId;
	}
}

class Playlist {
	private String name;
	private String id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
