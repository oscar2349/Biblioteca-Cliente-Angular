import { Autores } from './autores';
import { Libros } from './libros';
export class Editoriales {
  constructor(
    public idEditoriales: number = null,
    public nombre: string = null,
    public direccion: string = null,
    public telefono: string = null,
    public correoElectronico: string = null,
    public maximoLibrosRegistrados: string = null,
    public autoresList: Autores[]= null,
    public librosList: Libros[] = null

  ) {}
}
