package sistemasinformacion.practica5;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.document.TextField;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.Field;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.es.SpanishAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.core.SimpleAnalyzer;

import org.apache.lucene.store.Directory;
import org.apache.lucene.store.MMapDirectory;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.io.BufferedReader;


/**
 * Clase de ejemplo de un indexador y buscador usando Lucene
 * @author sisinf
 *
 */
public class IndexadorYBuscador{

	/**
	 * RelaciÃ³n de ficheros a indexar / buscar
	 */
	private Collection <String> ficherosAIndexar = new ArrayList<String>();
	/**
	 * RelaciÃ³n de palabras clave a buscar
	 */
	private Collection <String> queries = new ArrayList <String>();
	/**
	 * Analizar utilizado por el indexador / buscador 
	 */
	private Analyzer analizador;
	
	private static String INDEXDIR;
	
	

	/**
	 * Constructor parametrizado
	 * @param ficherosAIndexar ColecciÃ³n de ficheros a indexar
	 * @param queries ColecciÃ³n de palabras a buscar
	 */
	public IndexadorYBuscador(Collection<String> ficherosAIndexar, Collection<String> queries, String IndexDir){
		this.ficherosAIndexar = ficherosAIndexar;
		this.queries = queries;
		INDEXDIR = IndexDir;
		//analizador = new SimpleAnalyzer();

		/*try {
			FileReader reader = new FileReader("./ficheros/stopwords.txt");
			analizador = new StandardAnalyzer(reader);
		} catch (Exception e) {
			System.out.println("Error leyendo fichero de Stop Words. Usando valor por defecto");
			analizador = new StandardAnalyzer();
		} 
*/
		analizador = new SpanishAnalyzer();

	
	}
	
	
	
	/**
	 * AÃ±ade un fichero al Ã­ndice
	 * @param indice Indice que estamos construyendo
	 * @param path ruta del fichero a indexar
	 * @throws IOException
	 */
	private void anhadirFichero(IndexWriter indice, String path) 
	throws IOException {
		InputStream inputStream = new FileInputStream(path);
		BufferedReader inputStreamReader = new BufferedReader(
				new InputStreamReader(inputStream,"UTF-8"));
		
		Document doc = new Document();   
		doc.add(new TextField("contenido", inputStreamReader));
		doc.add(new StringField("path", path, Field.Store.YES));
		indice.addDocument(doc);
	}
	
	
	
	/**
	 * Indexa los ficheros incluidos en "ficherosAIndexar"
	 * @return un Ã­ndice (Directory) en memoria, con los Ã­ndices de los ficheros
	 * @throws IOException
	 */
	private Directory crearIndiceEnUnDirectorio() throws IOException{
		IndexWriter indice = null;
		Directory directorioAlmacenarIndice = new MMapDirectory(Paths.get(INDEXDIR));

		IndexWriterConfig configuracionIndice = new IndexWriterConfig(analizador);

		indice = new IndexWriter(directorioAlmacenarIndice, configuracionIndice);
		
		for (String fichero : ficherosAIndexar) {
			anhadirFichero(indice, fichero);
		}
		
		indice.close();
		return directorioAlmacenarIndice;
	}
	
	
	
	/**
	 * Busca la palabra indicada en queryAsString en el directorioDelIndice.
	 * @param directorioDelIndice
	 * @param paginas
	 * @param hitsPorPagina
	 * @param queryAsString
	 * @throws IOException
	 */
	private void buscarQueryEnIndice(Directory directorioDelIndice, 
										int paginas, 
										int hitsPorPagina, 
										String queryAsString)
	throws IOException{

		DirectoryReader directoryReader = DirectoryReader.open(directorioDelIndice);
		IndexSearcher buscador = new IndexSearcher(directoryReader);
		
		QueryParser queryParser = new QueryParser("contenido", analizador); 
		Query query = null;
		try{
			query = queryParser.parse(queryAsString);
			TopDocs resultado = buscador.search(query, paginas * hitsPorPagina);
			ScoreDoc[] hits = resultado.scoreDocs;
		      
			System.out.println("\nBuscando " + queryAsString + ": Encontrados " + hits.length + " hits.");
			int i = 0;
			for (ScoreDoc hit: hits) {
				int docId = hit.doc;
				
				Document doc = buscador.doc(docId);
				System.out.println((++i) + ". " + doc.get("path") + "\t" + hit.score);
			}

		}catch (ParseException e){
			throw new IOException(e);
		}	
	}
	
	
	
	/**
	 * Ejecuta en el Ã­ndice una bÃºsqueda por cada una de las palabras clave solicitadas. <p>
	 * Las palabras clave solicitadas estÃ¡n en la propiedad global "queries". 
	 * @param directorioDelIndice Ã­ndice
	 * @param paginas 
	 * @param hitsPorPagina
	 * @throws IOException
	 */
	private void buscarQueries(Directory directorioDelIndice, int paginas, int hitsPorPagina)
	throws IOException{
		for (String palabra : queries) {
			buscarQueryEnIndice(directorioDelIndice, 
								paginas, 
								hitsPorPagina, 
								palabra);			
		}
	}
	
	
	/**
	 * Programa principal de prueba. Rellena las colecciones "ficheros" y "queries"
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[]args) throws IOException{
		// Establecemos la lista de ficheros a indexar
		/*Collection <String> ficheros = new ArrayList <String>();
		ficheros.add("./ficheros/uno.txt");
		ficheros.add("./ficheros/dos.txt");
		ficheros.add("./ficheros/tres.txt");
		ficheros.add("./ficheros/cuatro.txt");

		// Establecemos las palabras clave a utilizar en la bÃºsqueda
		Collection <String> queries = new ArrayList <String>();
		queries.add("ContaminaciÃ³n");
		queries.add("cambio climatico");
		queries.add("cambio climÃ¡tico");
		queries.add("cambio");
		queries.add("climatico");
		queries.add("por");
		queries.add("aeropuerto");
		queries.add("contaminacion");
		queries.add("cambio climatico");

		// Creamos el idexador / buscador
		IndexadorYBuscador ejemplo = new IndexadorYBuscador(ficheros, queries);

		// Indexamos los ficheros
		//Directory directorioDelIndiceCreado = ejemplo.crearIndiceEnUnDirectorio();
		
		// Abrimos un ficher indexado previamente
		Directory directorioDelIndiceCreado = MMapDirectory.open(Paths.get(INDEXDIR));
		
		// Ejecutamos la bÃºsqueda de las palabras clave
		ejemplo.buscarQueries(directorioDelIndiceCreado, ficheros.size(), 1);*/
		
		
		int opcion_menu = 0;
		Scanner cin = new Scanner(System.in);
		Collection <String> ficheros = new ArrayList <String>();
		String IndexDir = new String();
		while (opcion_menu != 4) {
			System.out.println("\n1.- Indexar un directorio\n"+
							   "2.- Añadir un documento al indice (opcional)\n"+
							   "3.- Buscar termino\n"+
							   "4.- Salir\n");
			opcion_menu = cin.nextInt();
			switch (opcion_menu) {
			case 1:
				System.out.println("Elija directorio a indexar:");
				cin.nextLine();
				IndexDir = cin.nextLine();
				ficheros.clear();
				break;
			case 2:
				String fichero_a_anyadir = new String();
				cin.nextLine();
				fichero_a_anyadir = cin.nextLine();
				ficheros.add(fichero_a_anyadir);
				break;
			case 3:
				String termino_a_buscar = new String();
				cin.nextLine();
				termino_a_buscar = cin.nextLine();
				Collection <String> queries = new ArrayList <String>();
				queries.add(termino_a_buscar);
				if (IndexDir != null && !ficheros.isEmpty()) {
					IndexadorYBuscador ejemplo = new IndexadorYBuscador(ficheros, queries, IndexDir);
					Directory directorioDelIndiceCreado = ejemplo.crearIndiceEnUnDirectorio();
					ejemplo.buscarQueries(directorioDelIndiceCreado, ficheros.size(), 1);
				}else {
					System.out.println("Asegurate de haber indexado un directorio y haber añadido documentos al indice");
				}
				break;
				
			}
		}
	System.out.println("Bye Bye");
	cin.close();
	}
	
	
}


