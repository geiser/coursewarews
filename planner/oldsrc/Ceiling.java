
import com.gamalocus.jshop2rt.*;

public class Ceiling implements Calculate {

  @Override
  public Term call(List args) {
    TermNumber term = (TermNumber) args.getHead();
    return new TermNumber(Math.ceil(term.getNumber()));
  }

}

