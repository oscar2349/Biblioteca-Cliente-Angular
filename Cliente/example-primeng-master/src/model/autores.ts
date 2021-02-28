import { Editoriales } from './editoriales';
import { Libros } from './libros';
export class Autores {

    constructor(
        public idAutores: number = null,
        public nombreCompleto: string = null,
        public fechaNacimento: string = null,
        public ciudadProcedencia: string = null,
        public correoElectronico: string = null,
        public editorialesList: Editoriales[] = null,
        public librosList: Libros[] = null
      
      ) {}
}
