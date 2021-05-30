package kodlamaio.hrms.core.adapters;

import java.util.regex.Pattern;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.MernisDemoService;

@Service
public class MernisDemo implements  MernisDemoService {

	public boolean isValidNationolityIdentity(String tcNo) {

		String regex = "^[0-9]+$";

		if (tcNo.length() != 11) {
			return false;
		}
		Pattern pattern = Pattern.compile(regex);
		return pattern.matcher(tcNo).find();
	}

}
