package kishinoTest;

import java.io.ByteArrayInputStream;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("hello world!");

		// S3に接続
		AmazonS3 client = AmazonS3ClientBuilder.standard().withRegion(Regions.AP_NORTHEAST_1).build();;

		// S3へアップロード
		String naiyo = "どうしよう";

		ByteArrayInputStream bis = new ByteArrayInputStream(naiyo.getBytes());

		ObjectMetadata metaData = new ObjectMetadata();

		try {
			client.putObject("salad-bar-dev-static-files",  "TOPPAN/9999.txt", bis, metaData);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}


	}

}
