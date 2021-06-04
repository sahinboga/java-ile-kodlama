package kodlamaio.hrms.core.utilities.adapters.abstracts;

import java.io.IOException;

import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Image;

public interface ImageService {
	public Result uploadPhoto(Image image) throws IOException;
}
