package datatype;

import java.net.URI;
import java.util.HashMap;

/**
 * Standard article format.
 * Use when standard article information is required by the App.
 * @author Gerald Melles
 *
 */
public class StandardExchangeArticle {
public long ID;
public String name;
public String description;
public URI pictureURI;
public HashMap<Integer, String> flags;
}
