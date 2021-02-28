import { Autores } from './autores';
import { Editoriales } from './editoriales';
export class Libros {
  constructor(
    public idLibro: number = null,
    public titulo: string = null,
    public year: string = null,
    public genero: string = null,
    public numeroPaginas: string = null,
    public autoresIdAutores: Autores= null,
    public editorialesIdEditoriales: Editoriales = null
    
  ) {}
}
