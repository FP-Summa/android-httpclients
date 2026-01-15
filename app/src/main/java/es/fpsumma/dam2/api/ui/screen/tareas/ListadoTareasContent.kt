package es.fpsumma.dam2.api.ui.screen.tareas

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.NoteAdd
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@JvmOverloads
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListadoTareasContent(
    state: TareasUIState,
    onBack: () -> Unit,
    onAdd: () -> Unit,
    onOpenDetalle: (Int) -> Unit,
    onDelete: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Listado de tareas") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Volver")
                    }
                },
                actions = {
                    IconButton(onClick = onAdd) {
                        Icon(Icons.AutoMirrored.Filled.NoteAdd, contentDescription = "Añadir")
                    }
                }
            )
        }
    ) { innerPadding ->
        when {
            state.loading -> {
                LinearProgressIndicator(Modifier.fillMaxWidth())
            }

            state.error != null -> {
                Box(
                    modifier = modifier.fillMaxSize().padding(innerPadding),
                    contentAlignment = Alignment.Center
                ) {
                    Text(state.error)
                }
            }

            state.tareas.isEmpty() -> {
                Box(
                    modifier = modifier.fillMaxSize().padding(innerPadding),
                    contentAlignment = Alignment.Center
                ) {
                    Text("No hay tareas aún")
                }
            }

            else -> {
                LazyColumn(
                    modifier = modifier.fillMaxSize().padding(innerPadding)
                ) {
                    items(items = state.tareas, key = { it.id }) { tarea ->
                        Card(
                            onClick = { onOpenDetalle(tarea.id) },
                            modifier = modifier.padding(8.dp)
                        ) {
                            ListItem(
                                headlineContent = { Text(tarea.titulo) },
                                supportingContent = { Text(tarea.descripcion) },
                                trailingContent = {
                                    IconButton(onClick = { onDelete(tarea.id) }) {
                                        Icon(Icons.Outlined.Delete, contentDescription = "Borrar")
                                    }
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

