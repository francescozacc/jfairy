package eu.codearte.fairyland.producer;

import eu.codearte.fairyland.DataMaster;
import org.apache.commons.lang3.StringUtils;

/**
 * @author Codearte
 * @since 2013-10-07
 */
public class Company extends FairyProducer {

  private String name;
  private final String domain;
  private final String email;

  public Company(RandomDataGenerator generator, RandomGenerator random) {
    super(generator, random);
    name = generator.getValues(DataMaster.COMPANY_NAME);
    if (random.trueOrFalse()) {
      name += " " + generator.getValues(DataMaster.COMPANY_SUFFIX);
    }
    domain = StringUtils.strip(StringUtils.deleteWhitespace(name.toLowerCase()), ".")
        + "." + generator.getValues(DataMaster.DOMAIN);
    email = generator.getValues(DataMaster.COMPANY_EMAIL);
  }

  public String name() {
    return name;
  }

  public String url() {
    return "http://www." + domain;
  }

  public String email() {
    return email + "@" + domain;
  }

}