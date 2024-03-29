package Iterator; 


public interface Iterator<E> {
/**
* Vai para o inicio da coleccao de objectos
*/
void init();
/**
* Devolve <code>true</code> se existirem mais objectos a visitar,
* ou <code>false</code>, caso contrario
* @return se existem mais objectos a visitar
*/
boolean hasNext();
/**
* Devolve o proximo objecto
* @return proximo objecto
* @pre hasNext()
*/
String next();
}