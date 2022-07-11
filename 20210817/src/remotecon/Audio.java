package remotecon;

public class Audio 
    implements RemoteControl{
	int volume;
	
	@Override
	public void turnon() {
		System.out.println("Audio 켠다");
	}
	@Override
	public void turnoff() {
		System.out.println("Audio 끈다");
	}
	@Override
	public void setVolume(int volume) {
		if(volume > MAX_VOLUME) {
			this.volume = MAX_VOLUME;
		} else {
			this.volume = volume;
		}
		System.out.println("Audio 볼륨 : " + this.volume);
	}

}
