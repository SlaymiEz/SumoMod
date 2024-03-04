package fr.sumomod;

public class ListsMaps {
    double posX, posY, posZ;
    public double[][] SeasideEast = {{posX-2, posY, posZ}, {posX-2, posY, posZ+1}, {posX-2, posY, posZ-1}, {posX-2, posY, posZ+2}, {posX-2, posY, posZ-2},
            {posX-1, posY, posZ+3}, {posX-1, posY, posZ-3}, {posX-1, posY, posZ+4}, {posX-1, posY, posZ-4},
            {posX, posY, posZ+5}, {posX, posY, posZ-5},
            {posX+1, posY, posZ+6}, {posX+2, posY, posZ-6},
            {posX+2, posY, posZ+6}, {posX+2, posY, posZ-6},
            {posX+3, posY, posZ+7}, {posX+3, posY, posZ-7},
            {posX+4, posY, posZ+7}, {posX+4, posY, posZ-7},
            {posX+5, posY, posZ+7}, {posX+5, posY, posZ-7},
            {posX+6, posY, posZ+7}, {posX+6, posY, posZ-7},
            {posX+7, posY, posZ+7}, {posX+7, posY, posZ-7},
            {posX+8, posY, posZ+6}, {posX+8, posY, posZ-6},
            {posX+9, posY, posZ+6}, {posX+9, posY, posZ-6},
            {posX+10, posY, posZ+5}, {posX+10, posY, posZ-5},
            {posX+11, posY, posZ+4}, {posX+11, posY, posZ-4},
            {posX+12, posY, posZ+2}, {posX+12, posY, posZ-2},
            {posX+12, posY, posZ+1}, {posX+12, posY, posZ-1},
            {posX+12, posY, posZ}
    }; // Prob not working
    public double[][] SeasideNorth = {{posX, posY, posZ+2},{posX+1, posY, posZ+2},{posX-1, posY, posZ+2},{posX+2, posY, posZ+2},{posX-2, posY, posZ+2},
            {posX+3, posY, posZ+1},{posX-3, posY, posZ+1},{posX+4, posY, posZ+1},{posX-4, posY, posZ+1},
            {posX+5, posY, posZ},{posX-5, posY, posZ},
            {posX+5, posY, posZ-1},{posX-5, posY, posZ-1},
            {posX+6, posY, posZ-2},{posX-6, posY, posZ-2},
            {posX+6, posY, posZ-3},{posX-6, posY, posZ-3},
            {posX+6, posY, posZ-4},{posX-6, posY, posZ-4},
            {posX+6, posY, posZ-5},{posX-6, posY, posZ-5},
            {posX+6, posY, posZ-6},{posX-6, posY, posZ-6},
            {posX+5, posY, posZ-7},{posX-5, posY, posZ-7},
            {posX+5, posY, posZ-8},{posX-5, posY, posZ-8},
            {posX+4, posY, posZ-9},{posX-4, posY, posZ-9},
            {posX+2, posY, posZ-10},{posX-2, posY, posZ-10},{posX+1, posY, posZ-10},{posX-1, posY, posZ-10}, {posX, posY, posZ-10}
    };
    public double[][] SeasideSouth = {{posX, posY, posZ-2},{posX+1, posY, posZ-2},{posX-1, posY, posZ-2},{posX+2, posY, posZ-2},{posX-2, posY, posZ-2},
            {posX+3, posY, posZ-1},{posX-3, posY, posZ-1},{posX+4, posY, posZ-1},{posX-4, posY, posZ-1},
            {posX+5, posY, posZ},{posX-5, posY, posZ},
            {posX+5, posY, posZ+1},{posX-5, posY, posZ+1},
            {posX+6, posY, posZ+2},{posX-6, posY, posZ+2},
            {posX+6, posY, posZ+3},{posX-6, posY, posZ+3},
            {posX+6, posY, posZ+4},{posX-6, posY, posZ+4},
            {posX+6, posY, posZ+5},{posX-6, posY, posZ+5},
            {posX+6, posY, posZ+6},{posX-6, posY, posZ+6},
            {posX+5, posY, posZ+7},{posX-5, posY, posZ+7},
            {posX+5, posY, posZ+8},{posX-5, posY, posZ+8},
            {posX+4, posY, posZ+9},{posX-4, posY, posZ+9},
            {posX+2, posY, posZ+10},{posX-2, posY, posZ+10},{posX+1, posY, posZ+10},{posX-1, posY, posZ+10}, {posX, posY, posZ+10}};
    public double[][] BoxingNorth = {{posX, posY, posZ+2},{posX+1, posY, posZ+2},{posX-1, posY, posZ+2},{posX+2, posY, posZ+2},{posX-2, posY, posZ+2},
            {posX+3, posY, posZ+1},{posX-3, posY, posZ+1},
            {posX+4, posY, posZ},{posX-4, posY, posZ},
            {posX+5, posY, posZ-1},{posX-5, posY, posZ-1},
            {posX+6, posY, posZ-2},{posX-6, posY, posZ-2},
            {posX+6, posY, posZ-3},{posX-6, posY, posZ-3},
            {posX+6, posY, posZ-4},{posX-6, posY, posZ-4},
            {posX+6, posY, posZ-5},{posX-6, posY, posZ-5},
            {posX+6, posY, posZ-6},{posX-6, posY, posZ-6},
            {posX+6, posY, posZ-7},{posX-6, posY, posZ-7},
            {posX+6, posY, posZ-8},{posX-6, posY, posZ-8},
            {posX+5, posY, posZ-9},{posX-5, posY, posZ-9},
            {posX+4, posY, posZ-10},{posX-4, posY, posZ-10},
            {posX+3, posY, posZ-11},{posX-3, posY, posZ-11},
            {posX+2, posY, posZ-12},{posX-2, posY, posZ-12},{posX+1, posY, posZ-12},{posX-1, posY, posZ-12},{posX, posY, posZ-12}
    };
    public double[][] BoxingSouth ={{posX, posY, posZ-2},{posX+1, posY, posZ-2},{posX-1, posY, posZ-2},{posX+2, posY, posZ-2},{posX-2, posY, posZ-2},
            {posX+3, posY, posZ-1},{posX-3, posY, posZ-1},
            {posX+4, posY, posZ},{posX-4, posY, posZ},
            {posX+5, posY, posZ+1},{posX-5, posY, posZ+1},
            {posX+6, posY, posZ+2},{posX-6, posY, posZ+2},
            {posX+6, posY, posZ+3},{posX-6, posY, posZ+3},
            {posX+6, posY, posZ+4},{posX-6, posY, posZ+4},
            {posX+6, posY, posZ+5},{posX-6, posY, posZ+5},
            {posX+6, posY, posZ+6},{posX-6, posY, posZ+6},
            {posX+6, posY, posZ+7},{posX-6, posY, posZ+7},
            {posX+6, posY, posZ+8},{posX-6, posY, posZ+8},
            {posX+5, posY, posZ+9},{posX-5, posY, posZ+9},
            {posX+4, posY, posZ+10},{posX-4, posY, posZ+10},
            {posX+3, posY, posZ+11},{posX-3, posY, posZ+11},
            {posX+2, posY, posZ+12},{posX-2, posY, posZ+12},{posX+1, posY, posZ+12},{posX-1, posY, posZ+12},{posX, posY, posZ+12}
    };
    public double[][] TownRoadSouth ={};
}