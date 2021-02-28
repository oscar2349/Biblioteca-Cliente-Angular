import { Component, OnInit } from '@angular/core';
import { Libros } from 'src/model/libros';
import { PersonaService } from '../service/persona.service';
import { MenuItem } from 'primeng/components/common/menuitem';
import { MessageService, ConfirmationService } from 'primeng/api';
import { Autores } from '../../model/autores';
import { Editoriales } from '../../model/editoriales';

@Component({
  selector: 'app-persona',
  templateUrl: './persona.component.html',
  styleUrls: ['./persona.component.css']
})
export class PersonaComponent implements OnInit {

  personas: Libros[];
  cols: any[];
  items: MenuItem[];
  displaySaveDialog: boolean = false;
  persona: Libros = {
    idLibro: null,
    titulo: null,
    year: null,
    genero: null,
    numeroPaginas: null,  
    autoresIdAutores: null,
    editorialesIdEditoriales: null
  };

  selectedPersona: Libros = {
    idLibro: null,
    titulo: null,
    year: null,
    genero: null,
    numeroPaginas: null,
    autoresIdAutores: null,
    editorialesIdEditoriales: null
    
  };

  constructor(private personaService: PersonaService, private messageService: MessageService, private confirmService: ConfirmationService) { }

  getAll() {
    this.personaService.getAll().subscribe(
      (result: any) => {
        let personas: Libros[] = [];
        for (let i = 0; i < result.length; i++) {
          let persona = result[i] as Libros;

         console.log(persona);

          personas.push(persona);
        }
        this.personas = personas;
      },
      error => {
        console.log(error);
      }
    );
  }

  showSaveDialog(editar: boolean) {
    if (editar) {
      if (this.selectedPersona != null && this.selectedPersona.idLibro != null) {
        this.persona = this.selectedPersona;
      }else{
        this.messageService.add({severity : 'warn', summary: "Advertencia!", detail: "Por favor seleccione un registro"});
        return;
      }
    } else {
      this.persona = new Libros();
    }
    this.displaySaveDialog = true;
  }

  save() {
    this.personaService.save(this.persona).subscribe(
      (result: any) => {
        let persona = result as Libros;
        this.validarPersona(persona);
        this.messageService.add({ severity: 'success', summary: "Resultado", detail: "Se guardó la persona correctamente." });
        this.displaySaveDialog = false;

      },
      error => {
        console.log(error);
        
      }
    );
  }

  delete(){
    if(this.selectedPersona == null || this.selectedPersona.idLibro == null){
      this.messageService.add({severity : 'warn', summary: "Advertencia!", detail: "Por favor seleccione un registro"});
      return;
    }
    this.confirmService.confirm({
      message: "¿Está seguro que desea eliminar el registro?",
      accept : () =>{
        this.personaService.delete(this.selectedPersona.idLibro).subscribe(
          (result:any) =>{
            this.messageService.add({ severity: 'success', summary: "Resultado", detail: "Se eliminó la libro con id "+result.id+" correctamente." });
            this.deleteObject(result.idLibro);
          }
        )
      }
    })
  }

  deleteObject(id:number){
    let index = this.personas.findIndex((e) => e.idLibro == id);
    if(index != -1){
      this.personas.splice(index, 1);
    }
  }

  validarPersona(persona: Libros){
    let index = this.personas.findIndex((e) => e.idLibro == persona.idLibro);
console.log(persona);
    if(index != -1){
      this.personas[index] = persona;
    }else{
      this.personas.push(persona);

    }

  }
  
  ngOnInit() {
    this.getAll();
    this.cols = [
      { field: "idLibro", header: "IdLibro" },
      { field: "titulo", header: "TituloLibro" },
      { field: "year", header: "Año" },
      { field: "genero", header: "Genero" },
      { field: "numeroPaginas", header: "Numero de paginas" },
      { field: "autoresIdAutores", header: "IdAutores" },
      { field: "editorialesIdEditoriales", header: "IdEditoriales" }
    ];

    this.items = [
      {
        label: "Nuevo",
        icon: 'pi pi-fw pi-plus',
        command: () => this.showSaveDialog(false)
      },
      {
        label: "Editar",
        icon: "pi pi-fw pi-pencil",
        command: () => this.showSaveDialog(true)
      },
      {
        label: "Eliminar", 
        icon: "pi pi-fw pi-times",
        command: () => this.delete()
      }
    ]

  }

}
