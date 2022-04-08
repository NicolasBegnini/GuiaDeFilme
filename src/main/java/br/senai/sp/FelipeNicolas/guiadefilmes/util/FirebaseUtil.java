package br.senai.sp.FelipeNicolas.guiadefilmes.util;

import java.io.IOException;
import java.util.UUID;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

public class FirebaseUtil {

	private Credentials credenciais;

	private Storage storage;

	private final String BUCKET_NAME = "nicolas-guiafilmes.appspot.com";

	private final String PREFIX = "https://firebasestorage.googleapis.com/v0/b/";

	private final String SUFFIX = "?alt=media";

	private final String DOWNLOAD_URL = PREFIX + "%s" + SUFFIX;

	public FirebaseUtil() {
		// acessar o arquivo json com a chave privada
		Resource resource = new ClassPathResource("chaveFirebase.json");
		// gera uma credencial no firebase atraves da chave do arquivo

		try {
			credenciais = GoogleCredentials.fromStream(resource.getInputStream());
			// cria o storage para manipular os dados FireBase
			storage = StorageOptions.newBuilder().setCredentials(credenciais).build().getService();
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	// método para extrair a extensão do arquivo
	private String getExntesao(String nomeArquivo) {
		return nomeArquivo.substring(nomeArquivo.lastIndexOf("."));
	}

	// método que faz o upload
	public String upload(MultipartFile arquivo) {
		// gera uma String aleatória
		String nomeArquivo = UUID.randomUUID().toString() + getExntesao(arquivo.getOriginalFilename());
		return "";
	}

}
