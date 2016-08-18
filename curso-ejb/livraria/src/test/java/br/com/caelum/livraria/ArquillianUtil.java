//package br.com.caelum.livraria;
//
//import org.jboss.shrinkwrap.api.ArchivePaths;
//import org.jboss.shrinkwrap.api.ShrinkWrap;
//import org.jboss.shrinkwrap.api.asset.EmptyAsset;
//import org.jboss.shrinkwrap.api.spec.WebArchive;
//
//public class ArquillianUtil {
//
//	public static WebArchive criarWebArchive() {
//
//		WebArchive webArchive = ShrinkWrap
//				.create(WebArchive.class, "test.war")
//				.addAsWebInfResource(EmptyAsset.INSTANCE,
//						ArchivePaths.create("beans.xml"))
//				.addAsResource("META-INF/test-persistence.xml",
//						"META-INF/persistence.xml")
//				.addAsWebInfResource("test-ds.xml").addPackages(true, "br");
//		
//		return webArchive;
//	}
//}
