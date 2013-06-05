
package bsu.webapp.util;

import java.io.*;
import java.util.*;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;

public final class XSLTCashe {

    private static Map<String, Templates> cache = new HashMap();
    private static ReadWriteLock lock = new ReentrantReadWriteLock();

    public static Transformer newTransformer(String xsltFileName)
            throws TransformerConfigurationException {

        Templates template = cache.get(xsltFileName);

        if (template == null) {
            lock.writeLock().lock();
            try {
                if (!cache.containsKey(xsltFileName)) {
                    File xsltFile = new File(xsltFileName);
                    Source xslSource = new StreamSource(xsltFile);
                    TransformerFactory transFact = TransformerFactory.newInstance();
                    Templates templates = transFact.newTemplates(xslSource);
                    template = templates;
                    cache.put(xsltFileName, template);
                }
                else {
                    template = cache.get(xsltFileName);
                }
            } finally {
                lock.writeLock().unlock();
            }
        }

        return template.newTransformer();
    }

    private XSLTCashe() {
    }
}
