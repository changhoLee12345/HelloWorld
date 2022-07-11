package remotecon;

//통합리모콘 -> TV, Audio
//개발표준, 교체
public interface RemoteControl {
	int MAX_VOLUME = 10;  //public static final
	void turnon();        //public abstract
	void turnoff();
	void setVolume(int volume);
}
