package codeadvent.jupitermoons;

import java.util.ArrayList;
import java.util.List;

public class JupiterMoons {

    private static final int STEPS = 1000;

    public static void main(String[] args) {
//        Moon io = new Moon("io", new Vector(-1, 0, 2), new Vector(0, 0, 0));
//        Moon eu = new Moon("eu", new Vector(2, -10, -7), new Vector(0, 0, 0));
//        Moon ga = new Moon("ga", new Vector(4, -8, 8), new Vector(0, 0, 0));
//        Moon ca = new Moon("ca", new Vector(3, 5, -1), new Vector(0, 0, 0));

        Moon io = new Moon("io", new Vector(-9, -1, -1), new Vector(0, 0, 0));
        Moon eu = new Moon("eu", new Vector(2, 9, 5), new Vector(0, 0, 0));
        Moon ga = new Moon("ga", new Vector(10, 18, -12), new Vector(0, 0, 0));
        Moon ca = new Moon("ca", new Vector(-6, 15, -7), new Vector(0, 0, 0));

        System.out.println("----------------------------");
        log(io, eu, ga, ca);

        for (int i = 0; i < STEPS; i++) {
            System.out.println(i+1);
            updateVelocities(io, ca, eu, ga);
            updatePositions(io, ca, eu, ga);
            log(io, eu, ga, ca);
        }

        System.out.println(">>>>> RESULT: " + getEnergy(io, ca, eu, ga));
    }

    /* The total energy for a single moon is its potential energy multiplied by its kinetic energy.
    A moon's potential energy is the sum of the absolute values of its x, y, and z position coordinates.
    A moon's kinetic energy is the sum of the absolute values of its velocity coordinates.
    Below, each line shows the calculations for a moon's potential energy (pot), kinetic energy (kin),
    and total energy */
    private static long getEnergy(Moon io, Moon ca, Moon eu, Moon ga) {
            long ioPot = getPotentialE(io);
            long caPot = getPotentialE(ca);
            long euPot = getPotentialE(eu);
            long gaPot = getPotentialE(ga);
            long ioKin = getKineticE(io);
            long caKin = getKineticE(ca);
            long euKin = getKineticE(eu);
            long gaKin = getKineticE(ga);
            return (ioPot * ioKin) + (caPot * caKin) + (euPot * euKin) + (gaPot * gaKin);
    }

    private static long getPotentialE(Moon m) {
        return Math.abs(m.getPosition().getX()) + Math.abs(m.getPosition().getY()) + Math.abs(m.getPosition().getZ());
    }

    private static long getKineticE(Moon m) {
        return Math.abs(m.getVelocity().getX()) + Math.abs(m.getVelocity().getY()) + Math.abs(m.getVelocity().getZ());
    }

    private static void updateVelocities(Moon io, Moon ca, Moon eu, Moon ga) {
        List<MoonPair> pairs = getCombinations(io, ca, eu, ga);
        for (MoonPair pair : pairs) {
            applyGravity(pair);
        }
    }

    private static void applyGravity(MoonPair pair) {
        Moon m1 = pair.getMoon1();
        Moon m2 = pair.getMoon2();
        Vector p1 = m1.getPosition();
        Vector p2 = m2.getPosition();
        Vector v1 = m1.getVelocity();
        Vector v2 = m2.getVelocity();
        int vx1 = v1.getX();
        int vy1 = v1.getY();
        int vz1 = v1.getZ();
        int vx2 = v2.getX();
        int vy2 = v2.getY();
        int vz2 = v2.getZ();
        int px1 = p1.getX();
        int py1 = p1.getY();
        int pz1 = p1.getZ();
        int px2 = p2.getX();
        int py2 = p2.getY();
        int pz2 = p2.getZ();
        if (px2 > px1) {
            vx2 -= 1;
            vx1 += 1;
        } else if (px2 < px1) {
            vx2 += 1;
            vx1 -= 1;
        }
        if (py2 > py1) {
            vy2 -= 1;
            vy1 += 1;
        } else if (py2 < py1) {
            vy2 += 1;
            vy1 -= 1;
        }
        if (pz2 > pz1) {
            vz2 -= 1;
            vz1 += 1;
        } else if (pz2 < pz1) {
            vz2 += 1;
            vz1 -= 1;
        }
        m1.setVelocity(new Vector(vx1, vy1, vz1));
        m2.setVelocity(new Vector(vx2, vy2, vz2));
    }

    private static void updatePositions(Moon io, Moon ca, Moon eu, Moon ga) {
        io.setPosition(addVectors(io.getPosition(), io.getVelocity()));
        ca.setPosition(addVectors(ca.getPosition(), ca.getVelocity()));
        eu.setPosition(addVectors(eu.getPosition(), eu.getVelocity()));
        ga.setPosition(addVectors(ga.getPosition(), ga.getVelocity()));
    }

    private static Vector addVectors(Vector v1, Vector v2) {
        Vector result = new Vector(0, 0, 0);
        result.setX(v1.getX() + v2.getX());
        result.setY(v1.getY() + v2.getY());
        result.setZ(v1.getZ() + v2.getZ());
        return result;
    }

                                              //   1        2        3        4
    private static List<MoonPair> getCombinations(Moon io, Moon ca, Moon eu, Moon ga) {
        List<MoonPair> combinations = new ArrayList<>();
        combinations.add(new MoonPair(io, ca));
        combinations.add(new MoonPair(io, eu));
        combinations.add(new MoonPair(io, ga));
        combinations.add(new MoonPair(ca, eu));
        combinations.add(new MoonPair(ca, ga));
        combinations.add(new MoonPair(eu, ga));
        return combinations;
    }


    private static void log(Moon io, Moon eu, Moon ga, Moon ca) {
        System.out.println(io);
        System.out.println(eu);
        System.out.println(ga);
        System.out.println(ca);
        System.out.println("----------------------------");
    }

}
